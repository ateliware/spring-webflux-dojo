package com.ateliware.lab033.webfluxv1.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class TodoList {
    @Id
    String id;
    String title;
    String description;
    Boolean status;

    public TodoList() {
    }

    public TodoList(String title, String description) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.title = title;
        this.description = description;
        this.status = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
