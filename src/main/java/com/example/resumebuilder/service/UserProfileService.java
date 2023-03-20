package com.example.resumebuilder.service;

import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class UserProfileService {

    @PersistenceContext(unitName = "resumeUnit")
    private EntityManager entityManager;

    @Transactional
    public UserProfile saveUserProfile(UserProfile userProfile) {
        entityManager.persist(userProfile);
        entityManager.flush();
        return userProfile;
    }

    public Optional<UserProfile> getUserProfile(String username) {
        return entityManager.createNamedQuery("UserProfile.byUsername", UserProfile.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();
    }
}
