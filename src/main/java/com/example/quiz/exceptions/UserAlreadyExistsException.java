package com.example.quiz.exceptions;

public class UserAlreadyExistsException extends UserException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
