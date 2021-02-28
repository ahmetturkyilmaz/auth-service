package com.fitness.authservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.Date;

public class BaseEntity {
    @Id
    private String id;
    private String createdBy;
    private Date createdAt;
    @Version
    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

