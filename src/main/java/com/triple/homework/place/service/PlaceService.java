package com.triple.homework.place.service;

import com.triple.homework.place.model.PlaceDTO;
import com.triple.homework.place.model.PlaceEntity;
import com.triple.homework.place.repository.PlaceRepository;
import com.triple.homework.review.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public boolean addPlace(PlaceDTO placeDTO) {
        PlaceEntity placeEntity = placeRepository.findById(placeDTO.getPlaceId()).orElse(null);

        if(placeEntity == null){
            placeEntity = PlaceEntity.builder()
                    .placeId(placeDTO.getPlaceId())
                    .userId(placeDTO.getUserId())
                    .writeDt(new Date())
                    .build();

            placeRepository.save(placeEntity);
            return true;
        }

        return false;
    }

}
