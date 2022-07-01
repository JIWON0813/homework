package com.triple.homework.point.controller;

import com.triple.homework.point.service.PointService;
import com.triple.homework.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @GetMapping("/point/{user}")
    public ResponseEntity<UserDTO> events(@PathVariable("user") String userId){
        UserDTO userDTO = pointService.getPointById(userId);

        if(userDTO == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }
}
