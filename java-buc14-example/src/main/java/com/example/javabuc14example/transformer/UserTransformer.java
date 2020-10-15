package com.example.javabuc14example.transformer;

import com.example.javabuc14example.domain.User;
import com.example.javabuc14example.dto.UserDTO;

public class UserTransformer implements Transformer<User, UserDTO>{
    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(User user) {
        return null;
    }
}
