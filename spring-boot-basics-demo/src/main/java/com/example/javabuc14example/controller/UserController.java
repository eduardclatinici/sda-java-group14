package com.example.javabuc14example.controller;

import com.example.javabuc14example.domain.User;
import com.example.javabuc14example.dto.UserDTO;
import com.example.javabuc14example.repository.UserRepository;
import com.example.javabuc14example.service.UserService;
import com.example.javabuc14example.transformer.UserTransformer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;
    private final UserService userService;
    private final UserTransformer userTransformer;

    public UserController(UserRepository userRepository, UserService userService, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userTransformer = userTransformer;
    }
//CRUD
    //C- Create POST
    //R- Read GET
    //U- Update PUT
    //D- Delete DELETE

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<>(userRepository.findAll().stream()
                .map(userTransformer::toDTO)
                .collect(toList()), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public User findOneBy(@PathVariable("username") String username){
        return userRepository.getUserByUsername(username);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{username}")
    public User update(@PathVariable("username") String username, @RequestBody User user){
        User dbUser = userRepository.getUserByUsername(username);

        if(user.getUsername() != null) {
            dbUser.setUsername(user.getUsername());
        }
        if(user.getFirstName() != null) {
            dbUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null) {
            dbUser.setLastName(user.getLastName());
        }
        if(user.getPassword() != null) {
            dbUser.setPassword(user.getPassword());
        }

        return userRepository.save(dbUser);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable("username") String username){
        userService.deleteByUsername(username);
    }
}
