package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.UserProfile;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named
public class TemplateController implements Serializable {

    private UserProfile userProfile;
    private boolean currentUsersProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public boolean isCurrentUsersProfile() {
        return currentUsersProfile;
    }

    public void setCurrentUsersProfile(boolean currentUsersProfile) {
        this.currentUsersProfile = currentUsersProfile;
    }
}