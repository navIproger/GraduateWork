package com.example.techcollegebot.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Class {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    public Class() {
    }

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
