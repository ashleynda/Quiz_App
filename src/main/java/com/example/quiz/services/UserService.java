package com.example.quiz.services;

import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterUserRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginRequest loginRequest);
}
