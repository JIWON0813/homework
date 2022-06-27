package com.triple.homework.point.service;

import com.triple.homework.place.model.PlaceDTO;
import com.triple.homework.place.service.PlaceService;
import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.user.model.UserDTO;
import com.triple.homework.user.model.UserEntity;
import com.triple.homework.user.repository.UserRepository;
import com.triple.homework.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PlaceService placeService;

    private final UserRepository userRepository;

    private final PointService pointService;

    private final UserService userService;

    public void checkAddPoint(ReviewEntity reviewEntity) {
        int point = 0;
        point += reviewEntity.getContent().isEmpty() ? 0 : 1;
        point += reviewEntity.getAttachedPhotoIds().isEmpty() ? 0 : 1;


        boolean isFirstPlace = placeService.addPlace(new PlaceDTO(reviewEntity.getPlaceId(), reviewEntity.getUserId()));

        point += isFirstPlace ? 1 : 0;

        addPoint(reviewEntity,point);
    }

    public void addPoint(ReviewEntity reviewEntity, int point){
        UserEntity userEntity = userRepository.findById(reviewEntity.getUserId()).orElse(null);

        if(userEntity == null){
            userService.addUser(new UserDTO(reviewEntity.getUserId(), point));
            return;
        }

        userService.modifyPoint(reviewEntity.getUserId(),point);
    }
}
