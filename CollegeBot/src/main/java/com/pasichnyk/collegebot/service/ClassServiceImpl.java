package com.pasichnyk.collegebot.service;

import com.pasichnyk.collegebot.Entity.Group;
import com.pasichnyk.collegebot.dao.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassDAO classDAO;

    @Override
    public List<Group> getAllClass() {

        return classDAO.getAllClass();
    }
}
