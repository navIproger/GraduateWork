package com.pasichnyk.collegebot.service;

import com.pasichnyk.collegebot.Entity.Teacher;
import com.pasichnyk.collegebot.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public List<Teacher> getAllTeacher() {

        return teacherDAO.getAllTeacher();
    }
}
