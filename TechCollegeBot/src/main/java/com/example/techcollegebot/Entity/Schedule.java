package com.example.techcollegebot.Entity;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "class_id")
    int classId;

    @Column(name = "day_of_week")
    int dayOfWeek;

    @Column(name = "position_of_week")
    int positionOfWeek;

    @Column(name = "lesson_id")
    int lessonId;

    public Schedule() {
    }

    public Schedule(int classId, int dayOfWeek, int positionOfWeek, int lessonId) {
        this.classId = classId;
        this.dayOfWeek = dayOfWeek;
        this.positionOfWeek = positionOfWeek;
        this.lessonId = lessonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getPositionOfWeek() {
        return positionOfWeek;
    }

    public void setPositionOfWeek(int positionOfWeek) {
        this.positionOfWeek = positionOfWeek;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}
