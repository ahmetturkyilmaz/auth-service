package com.fitness.authservice.payload.response;

import com.fitness.authservice.model.Gender;
import com.fitness.authservice.model.Unit;

import java.util.List;

public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private String id;
    private String email;
    private String name;
    private String surname;
    private String gender;
    private String unit;
    private List<String> roles;

    public JwtResponse(String accessToken, String id, String email, String name, String surname, String gender, String unit, List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.unit = unit;
        this.roles = roles;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
