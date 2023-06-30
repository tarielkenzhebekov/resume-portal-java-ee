package com.example.resumebuilder.resources;

import com.example.resumebuilder.service.RegistrationService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/registration")
@RequestScoped
public class ConfirmationResource {

    @Inject
    RegistrationService registrationService;

    @GET
    @Path("/confirm")
    @Produces(MediaType.TEXT_PLAIN)
    public String confirm(@QueryParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
