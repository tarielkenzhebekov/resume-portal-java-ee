package com.example.resumebuilder.service;

import com.example.resumebuilder.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DataService {

    @PersistenceContext(unitName = "resumeUnit")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash passwordHasher;

    @Transactional
    public User createUser(
            String userName,
            String email,
            String password) {
        User user = new User(userName, email, passwordHasher.generate(password.toCharArray()));
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

//    TODO Remove this method later
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
    }
}
