package com.example.resumebuilder.service;

import com.example.resumebuilder.model.ConfirmationToken;
import com.example.resumebuilder.model.User;
import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DataService {

    @PersistenceContext(unitName = "resumeUnit")
    private EntityManager entityManager;

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

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    public UserProfile saveUserProfile(UserProfile userProfile) {
        entityManager.persist(userProfile);
        entityManager.flush();
        return userProfile;
    }

    @Transactional
    public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
        entityManager.persist(confirmationToken);
        entityManager.flush();
        return confirmationToken;
    }

}
