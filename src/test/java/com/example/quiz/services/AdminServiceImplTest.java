package com.example.quiz.services;

import com.example.quiz.data.repositories.AdminRepository;
import com.example.quiz.dtos.requests.AddQuestionsRequest;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    @BeforeEach
    public void startWith() {
        adminRepository.deleteAll();
    }

    @Test
    public void adminCanRegisterTest() {
        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
        registerAdminRequest.setAdmin("Axel");
        registerAdminRequest.setPassword("Alex");
        registerAdminRequest.setEmail("ashleyndabai@gmail.com");

        adminService.register(registerAdminRequest);
        assertThat(adminRepository.count(), is(1L));
    }

    @Test
    public void adminCanLoginTest() {
        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
        registerAdminRequest.setAdmin("Axel");
        registerAdminRequest.setPassword("Alex");
        registerAdminRequest.setEmail("ashleyndabai@gmail.com");

        adminService.register(registerAdminRequest);
        assertThat(adminRepository.count(), is(1L));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Axel");
        loginRequest.setPassword("Alex");

        LoginResponse loginResponse = adminService.login(loginRequest);
        assertThat(loginResponse.isLoggedIn(), is(true));
    }


    @Test
    @DisplayName("Test add question")
    public void addQuestionTest(){

        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
        registerAdminRequest.setAdmin("Tomide");
        registerAdminRequest.setPassword("Tomide");
        registerAdminRequest.setEmail("ashleyndabai@gmail.com");

        adminService.register(registerAdminRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Tomide");
        loginRequest.setPassword("Tomide");

        LoginResponse loginResponse = adminService.login(loginRequest);

        AddQuestionsRequest addQuestionsRequest = new AddQuestionsRequest();
        addQuestionsRequest.setQuestions("What is Everything");
        addQuestionsRequest.setWrongOptions("Nothing, Something, Anything");
        addQuestionsRequest.setOwner("Tomide");
        addQuestionsRequest.setAnswer("Everything");
        addQuestionsRequest.setCategory("General Question");

        String response = adminService.addQuestion(addQuestionsRequest);
        assertThat(response, is("Added Successfully") );


    }
}