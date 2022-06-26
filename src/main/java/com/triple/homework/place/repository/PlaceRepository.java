package com.triple.homework.place.repository;

import com.triple.homework.place.model.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, String> {
}
