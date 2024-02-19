package com.example.quiz.dtos.responses;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private boolean loggedIn;
    private String message;
}
