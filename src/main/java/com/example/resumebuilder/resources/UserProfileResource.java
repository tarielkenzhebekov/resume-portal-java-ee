package com.example.resumebuilder.resources;

import com.example.resumebuilder.controller.TemplateController;
import com.example.resumebuilder.model.UserProfile;
import com.example.resumebuilder.service.UserProfileService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
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

        UserProfile userProfile = userProfileService.getUserProfile(username).orElseThrow(
                () -> new IllegalStateException("Wrong URL"));
        templateController.setUserProfile(userProfile);

        String page = "/template-" + userProfile.getTheme() + ".xhtml";
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + page);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
