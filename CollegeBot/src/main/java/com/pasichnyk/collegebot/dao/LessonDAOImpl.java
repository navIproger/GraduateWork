package com.pasichnyk.collegebot.dao;

import com.pasichnyk.collegebot.Entity.Lesson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonDAOImpl implements LessonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getAllLesson() {
        Session session = entityManager.unwrap(Session.class);

        Query<Lesson> query = session.createQuery("from Lesson", Lesson.class);
        List<Lesson> allLesson = query.getResultList();

        return allLesson;
    }
}
