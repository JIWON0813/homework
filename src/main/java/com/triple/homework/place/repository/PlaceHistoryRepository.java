package com.triple.homework.place.repository;

import com.triple.homework.place.model.PlaceEntity;
import com.triple.homework.place.model.PlaceHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceHistoryRepository extends JpaRepository<PlaceHistoryEntity, Long> {
}
