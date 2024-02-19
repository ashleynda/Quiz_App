package com.example.quiz.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private Long id;
    private String username;
    private String password;
    private String age;
    private String email;
    private String gender;
}
