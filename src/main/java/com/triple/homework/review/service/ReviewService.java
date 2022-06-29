package com.triple.homework.review.service;

import com.triple.homework.place.model.PlaceEntity;
import com.triple.homework.place.repository.PlaceRepository;
import com.triple.homework.place.service.PlaceService;
import com.triple.homework.point.model.PointDTO;
import com.triple.homework.point.service.PointService;
import com.triple.homework.review.model.ReviewDTO;
import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.repository.ReviewRepository;
import com.triple.homework.user.model.UserEntity;
import com.triple.homework.user.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PointService pointService;
    private final PlaceService placeService;
    private final UserRepository userRepository;
    private final ReviewHistoryService reviewHistoryService;
    private final PlaceRepository placeRepository;

    public int events(ReviewDTO reviewDto) throws Exception {
        int result = 0;
        String action = reviewDto.getAction();

        switch (action) {
            case "ADD":
                result = addReview(reviewDto);
                break;
            case "MOD":
                result = modifyReview(reviewDto);
                break;
            case "DELETE":
                result = deleteReview(reviewDto);
                break;
            default:
                throw new Exception("Action Data Error");
        }

        return result;
    }

    @Transactional
    public int addReview(ReviewDTO reviewDto) throws Exception {
//        Optional<ReviewEntity> reviewEntity = reviewRepository.findById(reviewDto.getReviewId());
//
//        if(reviewEntity != null){
//            throw new Exception("이미 등록된 리뷰입니다.");
//        }

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .reviewId(reviewDto.getReviewId())
                .content(reviewDto.getContent())
                .attachedPhotoIds(String.join("&", reviewDto.getAttachedPhotoIds()))
                .userId(reviewDto.getUserId())
                .placeId(reviewDto.getPlaceId())
                .writeDt(new Date())
                .modifyDt(new Date())
                .build();

        ReviewEntity result = reviewRepository.save(reviewEntity);
        if(result == null){
            return 0;
        }

        //point text
        pointService.checkAddPoint(result);

        reviewHistoryService.addReviewHistory(result);

        return 1;
    }

    public int modifyReview(ReviewDTO reviewDto){
        ReviewEntity reviewEntity = reviewRepository.findById(reviewDto.getReviewId()).orElse(null);

        // photo update method
        UserEntity userEntity = userRepository.findById(reviewDto.getUserId()).orElse(null);
        int point = 0;

        if(reviewEntity.getAttachedPhotoIds().isEmpty() && !reviewDto.getAttachedPhotoIds().isEmpty()){
            // 사진을 추가하는 경우 +1점
            point += 1;
            pointService.addPoint(userEntity.getUserId(),point);
        }
        else if(!reviewEntity.getAttachedPhotoIds().isEmpty() && reviewDto.getAttachedPhotoIds().isEmpty()){
            // 사진을 삭제하는 경우 -1점
            point -= 1;
            pointService.addPoint(userEntity.getUserId(),point);
        }



        reviewEntity.setContent(reviewDto.getContent());
        reviewEntity.setAttachedPhotoIds(String.join("&", reviewDto.getAttachedPhotoIds()));
        reviewEntity.setModifyDt(new Date(System.currentTimeMillis()));

        ReviewEntity result = reviewRepository.save(reviewEntity);
        if(result == null){
            return 0;
        }

        return 1;

    }

    public int deleteReview(ReviewDTO reviewDto){
        ReviewEntity reviewEntity = reviewRepository.findById(reviewDto.getReviewId()).orElse(null);
        PlaceEntity placeEntity = placeRepository.findById(reviewDto.getPlaceId()).orElse(null);

        if(reviewEntity == null){
            return 0;
        }

        //벌었던 점수 글 존재, 사진존재 따라 -1 , -2
        //처음 등록한 장소 확인 -1
        //등록할때 처음 등록한 장소
        int point = -1; // content는 빈값이 있으면 안되니까
        point -= reviewEntity.getAttachedPhotoIds().isEmpty()? 0 : 1;

        if(placeEntity != null){
            point -= placeEntity.getUserId().equals(reviewEntity.getUserId()) ? 1 : 0;
            placeRepository.deleteById(placeEntity.getPlaceId());
        }

        try{
            reviewRepository.deleteById(reviewDto.getReviewId());
        }
        catch (Exception ex){
            return 0;
        }

        return 1;
    }
}
