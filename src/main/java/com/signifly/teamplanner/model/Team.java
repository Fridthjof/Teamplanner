package com.signifly.teamplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotNull
    @OneToOne
    private Person projectManager;

    @NotNull
    @ManyToOne
    private Person teamMembers;

    @NotNull
    @ManyToOne
    private Project project;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Person projectManager) {
        this.projectManager = projectManager;
    }

    public Person getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Person teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
