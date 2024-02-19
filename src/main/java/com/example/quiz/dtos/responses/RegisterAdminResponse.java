package com.example.quiz.dtos.responses;


import lombok.Data;

@Data
public class RegisterAdminResponse {
    private Long id;
    private String username;
    private String registerDate;
    private String message;
}
