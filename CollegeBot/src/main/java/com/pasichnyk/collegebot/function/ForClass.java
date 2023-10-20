package com.pasichnyk.collegebot.function;

import com.pasichnyk.collegebot.Entity.Group;
import com.pasichnyk.collegebot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForClass {

    @Autowired
    private ClassService classService;

    public int getClassId(String group){
        List<Group> groups = classService.getAllClass();

        for (Group grp : groups) {
            if (grp.equals(group)){
                return grp.getId();
            }
        }
        return 0;
    }
}
