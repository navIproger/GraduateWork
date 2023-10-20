package com.pasichnyk.techcollegebot.service;

import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.dao.GroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupDAO groupDAO;
    public List<Group> getAllGroups() {
        return groupDAO.findAll();
    }

    public Group getGroupByName(String name){
        return groupDAO.findByName(name);
    }
}
