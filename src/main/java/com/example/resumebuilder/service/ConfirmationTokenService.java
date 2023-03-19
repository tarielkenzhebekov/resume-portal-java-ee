package com.example.resumebuilder.service;

import com.example.resumebuilder.model.ConfirmationToken;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@ApplicationScoped
public class ConfirmationTokenService {

    @PersistenceContext(unitName = "resumeUnit")
    private EntityManager entityManager;

    public void setConfirmedAt(String token) {
        entityManager.createQuery("UPDATE ConfirmationToken c " +
                                            "SET c.confirmedAt = :now " +
                                                "WHERE c.token = :token")
                .setParameter("now", LocalDateTime.now())
                .setParameter("token", token)
                .executeUpdate();
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return entityManager.createNamedQuery("ConfirmationToken.byToken", ConfirmationToken.class)
                .setParameter("token", token)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Transactional
    public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
        entityManager.persist(confirmationToken);
        entityManager.flush();
        return confirmationToken;
    }
}
