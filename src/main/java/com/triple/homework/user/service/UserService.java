package com.triple.homework.user.service;

import com.triple.homework.user.model.UserDTO;
import com.triple.homework.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
