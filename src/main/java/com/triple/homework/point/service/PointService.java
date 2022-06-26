package com.triple.homework.point.service;

import com.triple.homework.place.service.PlaceService;
import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PlaceService placeService;

    private final UserRepository userRepository;

    public void checkAddPoint(ReviewEntity result) {
        int point = 0;
        point += result.getContent().isEmpty() ? 0 : 1;
        point += result.getAttachedPhotoIds().isEmpty() ? 0 : 1;

        boolean isFirstPlace = placeService.checkFirstRegisteredUserPlace(result.getPlaceId());

        point += isFirstPlace ? 1 : 0;

        //userRepository.save()
    }
}
