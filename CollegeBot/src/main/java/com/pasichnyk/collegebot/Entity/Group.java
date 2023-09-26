package com.pasichnyk.collegebot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class
Group {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;

    public Group() {
    }

    public Group(int id, String name) {
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

    @Override
    public String toString() {
        return "Class{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
