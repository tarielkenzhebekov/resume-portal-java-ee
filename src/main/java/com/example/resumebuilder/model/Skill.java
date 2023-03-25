package com.example.resumebuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "SKILLS")
public class Skill implements Serializable {

    @Id
    @SequenceGenerator(
            name = "SKILL_sequence",
            sequenceName = "SKILL_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SKILL_sequence"
    )
    @Column(name = "ID")
    private int id;

    @Column(name="SKILL")
    private String skillName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
