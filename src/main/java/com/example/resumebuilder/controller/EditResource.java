package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.UserProfile;
import com.example.resumebuilder.service.UserProfileService;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/edit")
public class EditResource {

    @Inject
    private SecurityContext securityContext;

    @Inject
    private EditController editController;

    @Inject
    private UserProfileService userProfileService;

    @GET
    @Produces("text/html")
    public Response edit(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws IOException {

        String username = securityContext.getCallerPrincipal().getName();
        UserProfile userProfile = userProfileService.getUserProfile(username).get();

        editController.setUserProfile(userProfile);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/edit.xhtml");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
