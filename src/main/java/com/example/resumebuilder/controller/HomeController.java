package com.example.resumebuilder.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RequestScoped
@Named
public class HomeController {

    @Inject
    private FacesContext facesContext;

    public String logout() throws ServletException {
        ExternalContext externalContext = facesContext.getExternalContext();
        ((HttpServletRequest) externalContext.getRequest()).logout();
        return "/index.xhtml?faces-redirect=true";
    }
}
