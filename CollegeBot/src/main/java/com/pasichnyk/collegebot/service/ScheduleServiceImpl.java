package com.pasichnyk.collegebot.service;

import com.pasichnyk.collegebot.Entity.Schedule;
import com.pasichnyk.collegebot.dao.ScheduleDAO;
import com.pasichnyk.collegebot.dao.ScheduleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleDAO scheduleDAO;
    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleDAO.getAllSchedule();
    }
}
