package com.example.javabuc14example.service;

import com.example.javabuc14example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void deleteByUsername(String username){
        userRepository.deleteByUsername(username);
    }
}
