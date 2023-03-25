package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.Education;
import com.example.resumebuilder.model.Job;
import com.example.resumebuilder.model.Skill;
import com.example.resumebuilder.model.UserProfile;
import com.example.resumebuilder.service.UserProfileService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@SessionScoped
@Named
public class EditController implements Serializable {

    @Inject
    private UserProfileService userProfileService;

    @Inject
    private SecurityContext securityContext;

    private UserProfile userProfile;

    @PostConstruct
    public void initialize() {
        if (securityContext.getCallerPrincipal() != null)
            this.userProfile = userProfileService.getUserProfile(securityContext.getCallerPrincipal().getName()).get();
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void remove(Job job) {
        userProfile.getJobs().remove(job);
    }

    public void remove(Education education) {
        userProfile.getEducations().remove(education);
    }

    public void remove(Skill skill) {
        userProfile.getSkills().remove(skill);
    }

    public void addJob() {
        userProfile.getJobs().add(new Job());
    }

    public void addEducation() {
        userProfile.getEducations().add(new Education());
    }

    public void addSkill() {
        userProfile.getSkills().add(new Skill());
    }

    @Transactional
    public void save() {
        userProfileService.saveUserProfile(userProfile);
    }

}

