package com.pasichnyk.techcollegebot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "lesson")
    private List<Schedule> schedules;

    public Lesson() {
    }

    public Lesson(int id, String name) {
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
        return "Lesson{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
