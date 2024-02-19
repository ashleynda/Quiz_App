package com.example.quiz.services;

import com.example.quiz.data.repositories.UserRepository;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterUserRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void startWith() {
        userRepository.deleteAll();
    }

    @Test
    public void registerUserTest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Favour");
        registerUserRequest.setPassword("password");
        registerUserRequest.setAge("15");
        registerUserRequest.setEmail("favour@gmail.com");
        registerUserRequest.setGender("male");

        userService.register(registerUserRequest);
        assertThat(userRepository.count(), is(1L));
    }
    @Test
    public void userCanLoginTest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Favour");
        registerUserRequest.setPassword("password");

        userService.register(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Favour");
        loginRequest.setPassword("password");

        LoginResponse loginResponse = userService.login(loginRequest);
        assertThat(loginResponse.isLoggedIn(), is(true));

    }

}