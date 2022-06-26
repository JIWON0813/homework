package com.triple.homework.place.model;

import lombok.Data;

import java.util.List;

@Data
public class PlaceDTO {

    private String type;
    private String action;
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
