package com.signifly.teamplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Technologies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @NotNull
    private String name;

    public Technologies() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
