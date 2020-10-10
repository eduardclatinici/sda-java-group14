package com.example.javabuc14example.controller;

import com.example.javabuc14example.domain.User;
import com.example.javabuc14example.repository.UserRepository;
import com.example.javabuc14example.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
//CRUD
    //C- Create POST
    //R- Read GET
    //U- Update PUT
    //D- Delete DELETE

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
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
