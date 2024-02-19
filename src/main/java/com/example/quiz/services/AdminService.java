package com.example.quiz.services;

import com.example.quiz.dtos.requests.AddQuestionsRequest;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterAdminResponse;
import com.example.quiz.dtos.responses.RegisterUserResponse;

public interface AdminService {
    RegisterAdminResponse register(RegisterAdminRequest registerAdminRequest);
    LoginResponse login(LoginRequest loginRequest);

    String addQuestion(AddQuestionsRequest addQuestionsRequest);
}

