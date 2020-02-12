package com.dev.springtest;

import com.dev.springtest.config.AppConfig;
import com.dev.springtest.model.User;
import com.dev.springtest.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Elizavetta");
        user1.setPassword("Charlie");

        User user2 = new User();
        user2.setName("Charles");
        user2.setPassword("Camilla");

        User user3 = new User();
        user3.setName("Harry");
        user3.setPassword("blackBumps");

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        userService.listUsers().stream().forEach(System.out::println);
    }
}
