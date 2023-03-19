package com.example.resumebuilder.service;

import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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
}
