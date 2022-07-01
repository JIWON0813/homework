package com.triple.homework.point.repository;

import com.triple.homework.place.model.PlaceEntity;
import com.triple.homework.point.model.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistoryEntity, Long> {
}
