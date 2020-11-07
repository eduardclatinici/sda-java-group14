package com.sda.catalogue.controller;

import com.sda.catalogue.dto.UserDTO;
import com.sda.catalogue.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO sellerDTO) {
        return this.userService.saveUser(sellerDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return this.userService.getUsers();
    }
}
