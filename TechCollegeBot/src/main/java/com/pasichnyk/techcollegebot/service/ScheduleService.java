package com.pasichnyk.techcollegebot.service;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.Entity.Schedule;
import com.pasichnyk.techcollegebot.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    public List<Schedule> getAllSchedule() {
        return scheduleDAO.findAll();
    }

    public List<Schedule> getGroupSchedule(Group group) {
        return scheduleDAO.findAllByGroup(group);
    }
}
