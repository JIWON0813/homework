package com.triple.homework.place.service;

import com.triple.homework.place.model.PlaceDTO;
import com.triple.homework.place.repository.PlaceRepository;
import com.triple.homework.review.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public boolean checkFirstRegisteredUserPlace(String placeId) {
        return true;
    }

    public void addUserByPlace(ReviewEntity result) {
    }
}
