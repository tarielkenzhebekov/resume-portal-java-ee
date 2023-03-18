package com.example.resumebuilder.controller;

import com.example.resumebuilder.service.RegistrationService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;

@RequestScoped
@Named
public class RegistrationController {

    @Inject
    private RegistrationService registrationService;

    @NotEmpty
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() {
        registrationService.register(username, email, password);
        return "/emailSent.xhtml?faces-redirect=true";
    }
}
