package com.triple.homework.review.repository;

import com.triple.homework.review.model.ReviewEntity;
import com.triple.homework.review.model.ReviewHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewHistoryRepository extends JpaRepository<ReviewHistoryEntity, Long> {

}
