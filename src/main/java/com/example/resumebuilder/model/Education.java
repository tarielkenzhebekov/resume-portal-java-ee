package com.example.resumebuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "EDUCATIONS")
public class Education implements Serializable {

    @Id
    @SequenceGenerator(
            name = "education_sequence",
            sequenceName = "education_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "education_sequence"
    )
    @Column(name = "ID")
    private int id;

    @Column(name = "COLLEGE")
    private String college;

    @Column(name = "QUALIFICATION")
    private String qualification;

    @Column(name = "MAJOR")
    private String major;

    public Education() {
    }

    public int getId() {
        return id;
    }

    public String getCollege() {
        return college;
    }

    public String getQualification() {
        return qualification;
    }

    public String getMajor() {
        return major;
    }
}