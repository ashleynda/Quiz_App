package com.example.quiz.controllers;

import com.example.quiz.dtos.requests.AddQuestionsRequest;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import com.example.quiz.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Quiz")
@AllArgsConstructor
public class AdminControllers {

    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(RegisterAdminRequest registerAdminRequest) {
        try {
            return new ResponseEntity<>(adminService.register(registerAdminRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(adminService.login(loginRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Object> addQuestion(AddQuestionsRequest addQuestionsRequest) {
        try {
            return new ResponseEntity<>(adminService.addQuestion(addQuestionsRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }
    }



}
