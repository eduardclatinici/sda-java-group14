package com.sda.spring.boot.command.line.runner;

import com.sda.spring.boot.command.line.runner.dto.UserDTO;
import com.sda.spring.boot.command.line.runner.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootCommandLineRunner implements CommandLineRunner {

    @Autowired
    RestService restService;

    @Autowired
    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandLineRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserDTO> users = restService.getAllUsers();
        System.out.println("What we received:" + users);
        System.out.println("Do something with that data (save to a different db, transform the data, etc..)");
        long count = users.stream()
                .filter(userDTO -> userDTO.getFirstName().toLowerCase().startsWith("e"))
                .count();
        System.out.println("There are " + count + " user with first names that start with the letter e");
        System.out.println("And close the runner");
        SpringApplication.exit(context);
    }

    //ETL Application
    //Extract
    //take data from another service
    //take data from service 2
    //take data from service 3
    //Transform
    //combine data from all three services after some pre-defined rules
    // and filter out some of them based on two specific fields (one from service 2 and one from servie 3)
    //Load
    //save in database
    //print
}
