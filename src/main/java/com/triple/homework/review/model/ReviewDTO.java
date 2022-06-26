package com.triple.homework.review.model;

import lombok.Data;

import java.util.List;

@Data
public class ReviewDTO {

    private String type;
    private String action;
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
