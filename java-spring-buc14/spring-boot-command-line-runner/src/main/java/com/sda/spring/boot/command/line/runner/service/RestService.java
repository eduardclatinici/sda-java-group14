package com.sda.spring.boot.command.line.runner.service;

import com.sda.spring.boot.command.line.runner.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class RestService {

    RestTemplate restTemplate = new RestTemplate();

    public List<UserDTO> getAllUsers(){
        ResponseEntity<UserDTO[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8081/users/",
                        UserDTO[].class);
        return response.getBody() == null ? emptyList() : Arrays.asList(response.getBody());
    }
}
