package com.dev.springtest.controllers;

import com.dev.springtest.dto.UserResponseDto;
import com.dev.springtest.model.User;
import com.dev.springtest.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/inject")
    private String injectUser() {
        User user1 = new User();
        user1.setName("Elizavetta");
        user1.setPassword("Charlie");

        User user2 = new User();
        user2.setName("Charles");
        user2.setPassword("Camilla");

        User user3 = new User();
        user3.setName("Harry");
        user3.setPassword("blackBumps");

        User user4 = new User();
        user4.setName("Therese");
        user4.setPassword("Margaret");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        return "Users was injected!";
    }

    @GetMapping(value = "/")
    private List<UserResponseDto> getUsers() {
        return userService.listUsers()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    private UserResponseDto getUser(@PathVariable(value = "id") Long id) {
        return userToDto(userService.getById(id));
    }

    private UserResponseDto userToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }

}
