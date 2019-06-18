package com.ateliware.lab033.webfluxv1.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoList {
    @Id
    Integer id;
    String title;
    String description;
    Boolean status;

    public TodoList() {
    }

    public TodoList(Integer id, String title, String description, Boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
