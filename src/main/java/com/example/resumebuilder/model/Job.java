package com.example.resumebuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JOBS")
public class Job implements Serializable {

    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_sequence"
    )
    @Column(name = "ID")
    private int id;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name = "START_DATE")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    TODO Search for an alternative in Jakarta EE
    private LocalDate startDate;

    @Column(name = "END_DATE")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    TODO Search for an alternative in Jakarta EE
    private LocalDate endDate;

    @Column(name = "CURRENT_JOB")
    private boolean currentJob;

    @Column(name = "RESPONSIBILITIES")
    @ElementCollection(targetClass = String.class)
    private List<String> responsibilities = new ArrayList<>();

    public Job() {
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isCurrentJob() {
        return currentJob;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }
}
