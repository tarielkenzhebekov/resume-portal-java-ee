package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.Education;
import com.example.resumebuilder.model.Job;
import com.example.resumebuilder.model.Skill;
import com.example.resumebuilder.model.UserProfile;
import com.example.resumebuilder.service.UserProfileService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@ApplicationScoped
@Named
public class EditController implements Serializable {

    @Inject
    private UserProfileService userProfileService;

    private UserProfile userProfile;

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

