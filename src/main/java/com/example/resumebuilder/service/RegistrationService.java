package com.example.resumebuilder.service;

import com.example.resumebuilder.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RegistrationService {

    @Inject
    private EmailValidator emailValidator;

    @Inject
    private UserService userService;

    public String register(
            String username,
            String email,
            String password) {
        boolean isValidEmail = emailValidator.test(email);
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        String token = userService.signUpUser(
            new User(
                    username,
                    email,
                    password
            )
        );

//       TODO Send an email

        return token;
    }
}
