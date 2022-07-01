package com.triple.homework.user.service;

import com.triple.homework.user.model.UserDTO;
import com.triple.homework.user.model.UserEntity;
import com.triple.homework.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public void modifyPoint(String userId, int point){
        UserEntity userEntity = userRepository.findById(userId).orElse(null);

        //삭제된 유저의 포인트를 바꾸려는 행동이므로 로그에만 쌓아줌
        if(userEntity == null){
            // 로그처리
        }


        userEntity.setPoint(point);

        userRepository.save(userEntity);
    }

    public void addUser(UserDTO userDTO){
        UserEntity userEntity = UserEntity.builder()
                .userId(userDTO.getUserId())
                .point(userDTO.getPoint())
                .writeDt(new Date())
                .modifyDt(new Date())
                .build();

        userRepository.save(userEntity);
    }
}
