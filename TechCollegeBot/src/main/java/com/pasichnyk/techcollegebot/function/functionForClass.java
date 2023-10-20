package com.pasichnyk.techcollegebot.function;

import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class functionForClass {

    @Autowired
    private GroupService groupService;
    public Group getClassByName(String name){
        return groupService.getGroupByName(name);
    }

}
