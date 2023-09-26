package com.pasichnyk.collegebot.dao;

import com.pasichnyk.collegebot.Entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeacher() {
        Session session = entityManager.unwrap(Session.class);

        Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
        List<Teacher> allTeacher = query.getResultList();

        return allTeacher;
    }
}
