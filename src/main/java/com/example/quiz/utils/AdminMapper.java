package com.example.quiz.utils;

import com.example.quiz.data.models.Admin;
import com.example.quiz.data.models.Question;
import com.example.quiz.dtos.requests.AddQuestionsRequest;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterAdminResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminMapper {
    public static Admin map(RegisterAdminRequest registerAdminRequest) {
        Admin admin = new Admin();
        admin.setUsername(registerAdminRequest.getAdmin());
        admin.setPassword(registerAdminRequest.getPassword());
        admin.setEmail(registerAdminRequest.getEmail());
        return admin;
    }

    public static RegisterAdminResponse map(Admin admin) {
        RegisterAdminResponse registerAdminResponse = new RegisterAdminResponse();
        registerAdminResponse.setUsername(admin.getUsername());
        registerAdminResponse.setRegisterDate(DateTimeFormatter
                .ofPattern("EEE dd/MMM/yyy HH:mm:ss a")
                .format(LocalDateTime.now()));
        registerAdminResponse.setMessage("Admin registered Successfully");
        registerAdminResponse.setId(admin.getId());
        return registerAdminResponse;
    }

    public static LoginResponse map(String id, Admin admin) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(admin.getId());
        loginResponse.setLoggedIn(true);
        loginResponse.setMessage("Admin logged in successfully");
        return loginResponse;
    }

    public static Question map(AddQuestionsRequest addQuestionsRequest) {
        Question question = new Question();
        question.setCategory(addQuestionsRequest.getCategory());
        question.setWrongOptions(addQuestionsRequest.getWrongOptions());
        question.setAnswer(addQuestionsRequest.getAnswer());
        question.setQuestions(addQuestionsRequest.getQuestions());
        question.setOwner(addQuestionsRequest.getOwner());
        return question;
    }
}
