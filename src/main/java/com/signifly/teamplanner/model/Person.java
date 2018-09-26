package com.signifly.teamplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/***
 * Entity of a Person.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @NotNull
    private String education;

    @ManyToOne
    private Technologies technologies;

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

    public Technologies getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Technologies technologies) {
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
