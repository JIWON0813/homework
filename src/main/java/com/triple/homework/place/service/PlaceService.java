package com.triple.homework.place.service;

import com.triple.homework.place.model.PlaceDTO;
import com.triple.homework.place.model.PlaceEntity;
import com.triple.homework.place.model.PlaceHistoryEntity;
import com.triple.homework.place.repository.PlaceHistoryRepository;
import com.triple.homework.place.repository.PlaceRepository;
import com.triple.homework.point.model.PointHistoryEntity;
import com.triple.homework.review.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceHistoryRepository placeHistoryRepository;

    public boolean addPlace(PlaceDTO placeDTO) {
        PlaceEntity placeEntity = placeRepository.findById(placeDTO.getPlaceId()).orElse(null);

        if(placeEntity == null){
            placeEntity = PlaceEntity.builder()
                    .placeId(placeDTO.getPlaceId())
                    .userId(placeDTO.getUserId())
                    .writeDt(new Date())
                    .build();

            placeRepository.save(placeEntity);

            PlaceHistoryEntity placeHistoryEntity = PlaceHistoryEntity.builder()
                    .status('I')
                    .placeId(placeDTO.getPlaceId())
                    .userId(placeDTO.getUserId())
                    .writeDt(new Date())
                    .build();

            placeHistoryRepository.save(placeHistoryEntity);
            return true;
        }

        return false;
    }

}
