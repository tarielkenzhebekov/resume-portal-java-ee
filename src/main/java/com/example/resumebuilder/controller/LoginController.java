package com.example.resumebuilder.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;

import java.io.IOException;

@RequestScoped
@Named
public class LoginController {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void execute() throws IOException {
        switch (processAuthentication()) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "Invalid Credentials",
                                null
                        )
                );
                break;
            case SUCCESS:
                getExternalContext().redirect("http://localhost:8080/resume/api/edit");
        }
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext externalContext = getExternalContext();

        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters
                        .withParams()
                        .credential(new UsernamePasswordCredential(username, password))
        );
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
