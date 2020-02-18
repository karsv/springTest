package com.dev.springtest.service.impl;

import com.dev.springtest.dao.UserDao;
import com.dev.springtest.model.User;
import com.dev.springtest.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
