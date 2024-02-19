package com.example.quiz.dtos.requests;

import lombok.Data;

@Data
public class RegisterAdminRequest {
   private String admin;
    private String password;
    private String email;
}
