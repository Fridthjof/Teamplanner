package com.signifly.teamplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


/***
 * Entity of a Person.
 */
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotNull
    private String education;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Technology> technologies;

    @NotNull
    private Long yearsOfExp;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private int cellnumber;


    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public Long getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(Long yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(int cellnumber) {
        this.cellnumber = cellnumber;
    }
}
