package com.sda.catalogue.service;

import com.sda.catalogue.domain.Role;
import com.sda.catalogue.domain.User;
import com.sda.catalogue.dto.UserDTO;
import com.sda.catalogue.repository.UserRepository;
import com.sda.catalogue.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Role findRoleByUsername(String username) {
        return userRepository.findRoleByUsername(username);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return userTransformer.toDTO(userRepository.save(userTransformer.toEntity(userDTO)));
    }

    public List<UserDTO> getUsers() {
        return this.userRepository.findAll().stream()
                .map(userTransformer::toDTO)
                .collect(Collectors.toList());
    }
}
