package com.pasichnyk.collegebot.dao;

import com.pasichnyk.collegebot.Entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Schedule> getAllSchedule() {
        Session session = entityManager.unwrap(Session.class);

        Query<Schedule> query = session.createQuery("from Schedule", Schedule.class);
        List<Schedule> allSchedule = query.getResultList();

        return allSchedule;
    }
}
