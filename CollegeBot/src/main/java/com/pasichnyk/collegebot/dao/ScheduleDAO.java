package com.pasichnyk.collegebot.dao;

import com.pasichnyk.collegebot.Entity.Schedule;

import java.util.List;

public interface ScheduleDAO {

    public List<Schedule> getAllSchedule();

    public List<Schedule> getGroupSchedule(int group);
}
