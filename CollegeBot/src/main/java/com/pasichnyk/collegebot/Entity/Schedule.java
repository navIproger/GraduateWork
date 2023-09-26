package com.pasichnyk.collegebot.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "day_of_week")
    int dayOfWeek;

    @Column(name = "position_of_week")
    int positionOfWeek;

    @Column(name = "audience")
    String audience;

    @Column(name = " time_start")
    String timeStart;

    @Column(name = "time_end")
    String timeEnd;

    public Schedule() {
    }

    public Schedule(Group group, Lesson lesson, Teacher teacher, int dayOfWeek, int positionOfWeek, String audience, String timeStart, String timeEnd) {
        this.group = group;
        this.lesson = lesson;
        this.teacher = teacher;
        this.dayOfWeek = dayOfWeek;
        this.positionOfWeek = positionOfWeek;
        this.audience = audience;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Година: " + timeStart + " - " + timeEnd + " Аудиторія: " + audience + "\n" +
                "Предмет: " + lesson.name + " Викладач: " + teacher.fullName + "\n";
    }
}
