package com.pasichnyk.techcollegebot.service;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.Entity.Lesson;
import com.pasichnyk.techcollegebot.dao.LessonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonDAO lessonDAO;

    public List<Lesson> getAllLessons() {
        return lessonDAO.findAll();
    }
}
