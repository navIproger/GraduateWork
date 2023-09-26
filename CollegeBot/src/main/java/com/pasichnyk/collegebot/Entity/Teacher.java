package com.pasichnyk.collegebot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "full_name")
    String fullName;

    @OneToMany(mappedBy = "teacher")
    private List<Schedule> schedules;

    public Teacher() {
    }

    public Teacher(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id = " + id +
                ", fullName = '" + fullName + '\'' +
                '}';
    }
}
