package com.triple.homework.review.controller;

import com.triple.homework.review.model.ReviewDTO;
import com.triple.homework.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/events")
    public ResponseEntity events(@RequestBody ReviewDTO reviewDto){
        int result = 0;

        try{
            result = reviewService.events(reviewDto);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        if(result > 0){
            return ResponseEntity.ok().body("성공");
        }

        return ResponseEntity.ok().body("실패");

    }
}
