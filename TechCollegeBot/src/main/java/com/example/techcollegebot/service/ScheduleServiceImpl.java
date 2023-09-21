package com.example.techcollegebot.service;

import com.example.techcollegebot.Entity.Schedule;
import com.example.techcollegebot.dao.ScheduleDAO;
import com.example.techcollegebot.dao.ScheduleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    public List<Schedule> getAllSchedule() {

        return scheduleDAO.getAllSchedule();
    }
}
