package com.triple.homework.review.service;

import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.model.ReviewHistoryEntity;
import com.triple.homework.review.repository.ReviewHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewHistoryService {

    private final ReviewHistoryRepository reviewHistoryRepository;

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
}
