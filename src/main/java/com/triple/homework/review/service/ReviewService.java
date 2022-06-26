package com.triple.homework.review.service;

import com.triple.homework.place.service.PlaceService;
import com.triple.homework.point.service.PointService;
import com.triple.homework.review.model.ReviewDTO;
import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.repository.ReviewRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final PointService pointService;

    private final PlaceService placeService;

    private final ReviewHistoryService reviewHistoryService;

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
        ReviewEntity reviewEntity = reviewRepository.findById(reviewDto.getReviewId()).get();

        if(reviewEntity != null){
            throw new Exception("이미 등록된 리뷰입니다.");
        }

        reviewEntity = ReviewEntity.builder()
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

        placeService.addUserByPlace(result);

        reviewHistoryService.addReviewHistory(result);


        return 1;
    }

    public int modifyReview(ReviewDTO reviewDto){
        ReviewEntity reviewEntity = reviewRepository.findById(reviewDto.getReviewId()).get();
        reviewEntity.setContent(reviewDto.getContent());
        reviewEntity.setAttachedPhotoIds(String.join("&", reviewDto.getAttachedPhotoIds()));
        reviewEntity.setModifyDt(new Date(System.currentTimeMillis()));

        // photo update method

        ReviewEntity result = reviewRepository.save(reviewEntity);
        if(result == null){
            return 0;
        }

        return 1;

    }

    public int deleteReview(ReviewDTO reviewDto){
        try{
            reviewRepository.deleteById(reviewDto.getReviewId());
        }
        catch (Exception ex){
            return 0;
        }

        return 1;
    }
}
