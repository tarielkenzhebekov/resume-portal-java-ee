package com.example.resumebuilder.service;

import com.example.resumebuilder.model.ConfirmationToken;
import com.example.resumebuilder.model.User;
import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    @Inject
    private UserProfileService userProfileService;

    @Inject
    private ConfirmationTokenService confirmationTokenService;

    @Inject
    private Pbkdf2PasswordHash passwordHasher;

    @PersistenceContext
    private EntityManager entityManager;

    public String signUpUser(User user) {
        boolean userExists = getUser(user.getUsername()).isPresent();

        if (userExists) {
            throw new IllegalStateException("Username already taken");
        }

        String encodedPassword = passwordHasher.generate(user.getPassword().toCharArray());
        user.setPassword(encodedPassword);

        saveUser(user);

        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(user.getUsername());
        userProfile.setTheme(1);
        userProfile.setEmail(user.getEmail());
        userProfileService.saveUserProfile(userProfile);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public void enableUser(String username) {
        entityManager.createQuery("UPDATE User u " +
                                            "SET u.enabled = TRUE " +
                                                "WHERE u.username = :username")
                .setParameter("username", username)
                .executeUpdate();
    }

    @Transactional
    public User saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    public Optional<User> getUser(String username) {
        return entityManager.createNamedQuery("User.byUsername", User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();
    }
}
