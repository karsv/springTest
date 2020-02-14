package com.dev.springtest.dto;

import com.dev.springtest.model.User;

public class UserResponseDto {
    private String name;
    private String password;

    public UserResponseDto(User user) {
        name = user.getName();
        password = user.getPassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
