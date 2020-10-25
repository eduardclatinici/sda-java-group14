package com.sda.catalogue.transformer;

import com.sda.catalogue.domain.User;
import com.sda.catalogue.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTransformer implements Transformer<User, UserDTO>{

    private final UserDetailsTransformer userDetailsTransformer;

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRating(userDTO.getRating());
        user.setUserDetails(userDetailsTransformer.toEntity(userDTO.getUserDetailsDTO()));
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .rating(user.getRating())
                .userDetailsDTO(userDetailsTransformer.toDTO(user.getUserDetails()))
                .build();
    }
}
