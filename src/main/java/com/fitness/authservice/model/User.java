package com.fitness.authservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document
public class User extends BaseEntity {

    @NotBlank
    @Size(max = 20)
    private String email;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String surname;


    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    private String gender;

    @NotBlank
    private String unit;

    private Set<Role> roles = new HashSet<>();


    public User() {
    }

    public User(String email,
                String name,
                String surname,
                String password,
                String gender,
                String unit) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.unit = unit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
