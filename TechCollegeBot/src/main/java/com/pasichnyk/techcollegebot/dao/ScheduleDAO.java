package com.pasichnyk.techcollegebot.dao;

import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {

    public List<Schedule> findAll();

    public List<Schedule> findAllByGroup(Group group);

}
