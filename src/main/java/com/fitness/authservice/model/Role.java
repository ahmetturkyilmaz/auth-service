package com.fitness.authservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role extends BaseEntity{

    private ERole name;

    public Role() {

    }


    public Role(ERole name) {
        this.name = name;
    }



	public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}