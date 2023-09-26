package com.pasichnyk.collegebot.service;

import com.pasichnyk.collegebot.Entity.Lesson;
import com.pasichnyk.collegebot.dao.LessonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    private LessonDAO lessonDAO;

    @Override
    public List<Lesson> getAllLesson() {

        return lessonDAO.getAllLesson();
    }
}
