package com.example.resumebuilder.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class DataInitializer {

    @Inject
    private DataService dataService;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (dataService.getAllUsers().isEmpty()) {
            dataService.createUser("japar", "japar@example.com", "password");
        }
    }
}
