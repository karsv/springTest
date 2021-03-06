package com.dev.springtest.dao;

import com.dev.springtest.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User getById(Long id);

    List<User> listUsers();
}
