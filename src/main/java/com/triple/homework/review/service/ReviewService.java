package com.triple.homework.review.service;

import com.triple.homework.review.model.ReviewDTO;
import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.repository.ReviewRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public int events(ReviewDTO reviewDto) throws Exception {
        int result = 0;
        String action = reviewDto.getAction();

        switch (action) {
            case "ADD":
                result = addReview(reviewDto);
                break;
            case "MOD":
                modifyReview(reviewDto);
                break;
            case "DELETE":
                deleteReview(reviewDto);
                break;
            default:
                throw new Exception("Action Data Error");
        }

        return result;
    }

    @Transactional
    public int addReview(ReviewDTO reviewDto){
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .reviewId(reviewDto.getReviewId())
                .content(reviewDto.getContent())
                .attachedPhotoIds(String.join("&", reviewDto.getAttachedPhotoIds()))
                .userId(reviewDto.getUserId())
                .placeId(reviewDto.getPlaceId())
                .build();

        ReviewEntity result = reviewRepository.save(reviewEntity);
        if(result == null){
            return 0;
        }

        return 1;
    }

    public int modifyReview(ReviewDTO reviewDto){
        ReviewEntity reviewEntity = reviewRepository.findById(reviewDto.getReviewId()).get();
        reviewEntity.setContent(reviewDto.getContent());
        reviewEntity.setAttachedPhotoIds(String.join("&", reviewDto.getAttachedPhotoIds()));

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
