package com.example.quiz.dtos.requests;

import lombok.Data;

import java.util.List;

@Data
public class AddQuestionsRequest {
    private String category;
    private String wrongOptions ;
    private String answer;
    private String questions;
    private String owner;
}
