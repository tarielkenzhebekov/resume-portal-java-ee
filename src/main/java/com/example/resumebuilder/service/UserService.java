package com.example.resumebuilder.service;

import com.example.resumebuilder.model.ConfirmationToken;
import com.example.resumebuilder.model.User;
import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    @Inject
    private DataService dataService;

    @Inject
    private Pbkdf2PasswordHash passwordHasher;

    public String signUpUser(User user) {
        boolean userExists = dataService.getUser(user.getUsername()).isPresent();

        if (userExists) {
            throw new IllegalStateException("Username already taken");
        }

        String encodedPassword = passwordHasher.generate(user.getPassword().toCharArray());
        user.setPassword(encodedPassword);

        dataService.saveUser(user);

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(user.getUsername());
        userProfile.setTheme(1);
        userProfile.setEmail(user.getEmail());
        dataService.saveUserProfile(userProfile);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        dataService.saveConfirmationToken(confirmationToken);

        return token;


    }
}
