package com.example.quiz.utils;

import com.example.quiz.data.models.User;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterUserRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setAge(registerUserRequest.getAge());
        user.setEmail(registerUserRequest.getEmail());
        user.setGender(registerUserRequest.getGender());
        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(user.getUsername());
        registerUserResponse.setRegisterDate(DateTimeFormatter
                .ofPattern("EEE dd/MMM/yyy HH:mm:ss a")
                .format(LocalDateTime.now()));
        registerUserResponse.setMessage("Successful");
        registerUserResponse.setId(user.getId());
        return registerUserResponse;
    }

    public static LoginResponse map(String id, User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(user.getId());
        loginResponse.setLoggedIn(true);
        loginResponse.setMessage("LoggedIn Successful");
        return loginResponse;
    }


}
