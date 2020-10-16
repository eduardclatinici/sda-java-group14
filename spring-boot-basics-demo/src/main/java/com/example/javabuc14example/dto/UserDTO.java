package com.example.javabuc14example.dto;

import com.example.javabuc14example.domain.User;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    public User toEntity(UserDTO userDTO) {
        return null;
    }

    public UserDTO toDTO(User user) {
        return null;
    }
}
