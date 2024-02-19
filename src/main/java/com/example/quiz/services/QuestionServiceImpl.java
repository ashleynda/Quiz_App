package com.example.quiz.services;

import com.example.quiz.data.models.Question;
import com.example.quiz.data.repositories.QuestionRepository;
import com.example.quiz.dtos.requests.AddQuestionsRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.quiz.utils.AdminMapper.map;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{


    private QuestionRepository questionRepository;

//    @Override
//    public Question findQuestion(String category, String questions) {
//        return null;
//    }

    @Override
    public String addQuestion(AddQuestionsRequest addQuestionsRequest) {
        Question question = map(addQuestionsRequest);
        questionRepository.save(question);
        return "Added Successfully";


    }
}
