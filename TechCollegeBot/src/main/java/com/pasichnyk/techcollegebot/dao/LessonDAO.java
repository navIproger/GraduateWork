package com.pasichnyk.techcollegebot.dao;

import com.pasichnyk.techcollegebot.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Integer> {

    public List<Lesson> findAll();
}
