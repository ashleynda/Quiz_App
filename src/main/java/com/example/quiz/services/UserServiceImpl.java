package com.example.quiz.services;

import com.example.quiz.data.models.User;
import com.example.quiz.data.repositories.UserRepository;
import com.example.quiz.dtos.requests.LoginRequest;
import com.example.quiz.dtos.requests.RegisterUserRequest;
import com.example.quiz.dtos.responses.LoginResponse;
import com.example.quiz.dtos.responses.RegisterUserResponse;
import com.example.quiz.exceptions.IncorrectDetailsException;
import com.example.quiz.exceptions.UserAlreadyExistsException;
import com.example.quiz.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.quiz.utils.Mapper.map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        checkForUniqueUsername(registerUserRequest);
        return map(userRepository.save(map(registerUserRequest)));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = findUser(loginRequest);
        validatePassword(loginRequest, user);

        user.setLoggedIn(true);
        userRepository.save(user);

        return map(String.valueOf(user.getId()), user);
    }

    private User findUser(LoginRequest loginRequest) {
        Optional <User> foundUser = userRepository.findByUsername(loginRequest.getUsername());
        if (foundUser.isEmpty()) throw new UserNotFoundException("User not found");
        return foundUser.get();
    }

    private void validatePassword(LoginRequest loginRequest, User user) {
        if (!user.getPassword().equals(loginRequest.getPassword()))
            throw new IncorrectDetailsException("Invalid username or password");
    }



    private void checkForUniqueUsername(RegisterUserRequest registerUserRequest) {
        Optional <User> user = userRepository.findByUsername(registerUserRequest.getUsername());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User name already exists");
        }
    }


}
