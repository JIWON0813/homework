package com.triple.homework.point.model;

import lombok.Data;

import java.util.List;

@Data
public class PointDTO {

    private String type;
    private String action;
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
