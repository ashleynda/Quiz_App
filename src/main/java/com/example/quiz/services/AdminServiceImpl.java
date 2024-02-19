package com.example.quiz.services;

import com.example.quiz.data.models.Admin;
import com.example.quiz.data.repositories.AdminRepository;
import com.example.quiz.dtos.requests.AddQuestionsRequest;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterAdminResponse;
import com.example.quiz.exceptions.AdminAlreadyExistsException;
import com.example.quiz.exceptions.AdminNotFoundException;
import com.example.quiz.exceptions.IncorrectDetailsException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.quiz.utils.AdminMapper.map;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    private QuestionService questionService;

    @Override
    public RegisterAdminResponse register(RegisterAdminRequest registerAdminRequest) {
        findAdmin(registerAdminRequest);
        return map(adminRepository.save(map(registerAdminRequest)));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Admin admin = foundAdmin(loginRequest);
        validatePassword(loginRequest, admin);

        admin.setLoggedIn(true);
        adminRepository.save(admin);

        return map(String.valueOf(admin.getId()), admin);
    }

    @Override
    public String addQuestion(AddQuestionsRequest addQuestionsRequest) {
        questionService.addQuestion(addQuestionsRequest);
        return "Added Successfully";
    }

    private Admin foundAdmin(LoginRequest loginRequest) {
        Optional <Admin> admin = adminRepository.findAdminByUsername(loginRequest.getUsername());
        if (admin.isEmpty()) throw new AdminNotFoundException("Admin not found");
        return admin.get();
    }

    private void validatePassword(LoginRequest loginRequest, Admin admin) {
        if (!admin.getPassword().equals(loginRequest.getPassword()))
            throw new IncorrectDetailsException("Invalid username or password");
    }

    private void findAdmin(RegisterAdminRequest registerAdminRequest) {
        Optional <Admin> admin = adminRepository.findAdminByUsername(registerAdminRequest.getAdmin());
        if (admin.isPresent()) {
            throw new AdminAlreadyExistsException("Admin already exists");
        }
    }
}
