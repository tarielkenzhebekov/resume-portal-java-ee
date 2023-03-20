package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.UserProfile;
import com.example.resumebuilder.service.UserProfileService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/view")
@RequestScoped
public class UserProfileResource {

    @Inject
    private SecurityContext securityContext;

    @Inject
    private TemplateController templateController;

    @Inject
    private UserProfileService userProfileService;

    @GET
    @Path("/{username}")
    @Produces("text/html")
    public Response view(
            @PathParam("username") String username,
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws IOException {

        if (securityContext.getCallerPrincipal() != null) {
            templateController.setPrincipalName(securityContext.getCallerPrincipal().getName());
            if (securityContext.getCallerPrincipal().getName().equals(username)) {
                templateController.setCurrentUsersProfile(true);
            }
        }

        UserProfile userProfile = userProfileService.getUserProfile(username).orElseThrow(
                () -> new IllegalStateException("Wrong URL"));
        templateController.setUserProfile(userProfile);

//        TODO Display a template according to the user's preference
        String page = "/template-2.xhtml";
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + page);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
