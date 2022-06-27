package com.triple.homework.review.service;

import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.model.ReviewHistoryEntity;
import com.triple.homework.review.repository.ReviewHistoryRepository;
import com.triple.homework.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ReviewHistoryService {

    private final ReviewHistoryRepository reviewHistoryRepository;

    private final ReviewRepository reviewRepository;

    public void addReviewHistory(ReviewEntity review) {
        ReviewHistoryEntity reviewHistoryEntity = ReviewHistoryEntity.builder()
                .status('I')
                .reviewId(review.getReviewId())
                .userId(review.getUserId())
                .afterContent(review.getContent())
                .afterPhoto(String.join("&", review.getAttachedPhotoIds()))
                .writeDt(new Date())
                .build();

        ReviewHistoryEntity result = reviewHistoryRepository.save(reviewHistoryEntity);
        if(result == null){
            //로그 남기기
        }
    }

    public void modifyReviewHistory(ReviewEntity review) {
        ReviewEntity beforeEntity = reviewRepository.findById(review.getReviewId()).orElse(null);

        //삭제되었는데 바꾸려고 하는거니 에러
        //이력 테이블의 에러때문에 서비스 사용에 지장을 주는건 문제가 있기 때문에 로그에만 쌓기
        if(beforeEntity == null){
            //로그쌓기
        }

        ReviewHistoryEntity reviewHistoryEntity = ReviewHistoryEntity.builder()
                .status('U')
                .reviewId(review.getReviewId())
                .userId(review.getUserId())
                .beforeContent(isNull(beforeEntity)? "" : beforeEntity.getContent())
                .beforePhoto(isNull(beforeEntity)? "" : beforeEntity.getAttachedPhotoIds())
                .afterContent(review.getContent())
                .afterPhoto(String.join("&", review.getAttachedPhotoIds()))
                .writeDt(new Date())
                .build();

        ReviewHistoryEntity result = reviewHistoryRepository.save(reviewHistoryEntity);
        if(result == null){
            //로그 남기기
        }
    }

    public void deleteReviewHistory(ReviewEntity review) {
        ReviewHistoryEntity reviewHistoryEntity = ReviewHistoryEntity.builder()
                .status('D')
                .reviewId(review.getReviewId())
                .userId(review.getUserId())
                .writeDt(new Date())
                .build();

        ReviewHistoryEntity result = reviewHistoryRepository.save(reviewHistoryEntity);
        if(result == null){
            //로그 남기기
        }
    }
}
