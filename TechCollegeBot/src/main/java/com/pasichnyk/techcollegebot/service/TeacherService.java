package com.pasichnyk.techcollegebot.service;

import com.pasichnyk.techcollegebot.Entity.Teacher;
import com.pasichnyk.techcollegebot.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public List<Teacher> getAllTeacher(){
        return teacherDAO.findAll();
    }
}
