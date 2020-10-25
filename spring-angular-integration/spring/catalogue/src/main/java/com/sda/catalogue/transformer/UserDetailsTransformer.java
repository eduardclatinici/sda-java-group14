package com.sda.catalogue.transformer;

import com.sda.catalogue.domain.UserDetails;
import com.sda.catalogue.dto.UserDetailsDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsTransformer implements Transformer<UserDetails, UserDetailsDTO>{


    @Override
    public UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(userDetailsDTO.getUsername());
        userDetails.setPassword(userDetailsDTO.getPassword());
        userDetails.setRole(userDetailsDTO.getRole());
        return userDetails;
    }

    @Override
    public UserDetailsDTO toDTO(UserDetails userDetails) {
        return UserDetailsDTO.builder()
                .username(userDetails.getUsername())
                .role(userDetails.getRole())
                .build();
    }
}
