package com.dev.springtest.service;

import com.dev.springtest.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User getById(Long id);

    List<User> listUsers();
}
