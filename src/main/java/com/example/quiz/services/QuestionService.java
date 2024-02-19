package com.example.quiz.services;

import com.example.quiz.data.models.Question;
import com.example.quiz.dtos.requests.AddQuestionsRequest;

public interface QuestionService {

//    Question findQuestion(String category, String questions);
    String addQuestion(AddQuestionsRequest addQuestionsRequest);
}
