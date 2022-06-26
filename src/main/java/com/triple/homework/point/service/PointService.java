package com.triple.homework.point.service;

import com.triple.homework.place.service.PlaceService;
import com.triple.homework.review.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PlaceService placeService;

    public void checkAddPoint(ReviewEntity result) {
        if(result.getContent().length() > 0){

        }
        if(result.getAttachedPhotoIds().length() > 0){

        }
        boolean isFirstPlace = placeService.checkFirstRegisteredUserPlace(result.getPlaceId());

        if(isFirstPlace){
            // +1
        }
    }
}
