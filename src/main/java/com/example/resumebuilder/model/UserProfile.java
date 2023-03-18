package com.example.resumebuilder.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_PROFILES")
public class UserProfile {

    @Id
    @SequenceGenerator(
            name = "user_profile_sequence",
            sequenceName = "user_profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_profile_sequence"
    )
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "THEME")
    private int theme;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "DESIGNATION")
    private String designation;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "USER_PROFILE_ID")
    List<Job> jobs = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "USER_PROFILE_ID")
    List<Education> educations = new ArrayList<>();

    @Column(name = "SKILLS")
    @ElementCollection(targetClass = String.class)
    List<String> skills = new ArrayList<>();

    public UserProfile() {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getTheme() {
        return theme;
    }

    public String getSummary() {
        return summary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDesignation() {
        return designation;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<String> getSkills() {
        return skills;
    }
}