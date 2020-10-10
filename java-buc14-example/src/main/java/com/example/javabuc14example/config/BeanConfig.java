package com.example.javabuc14example.config;

import com.example.javabuc14example.repository.UserRepository;
import com.example.javabuc14example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final UserRepository userRepository;

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }

}
