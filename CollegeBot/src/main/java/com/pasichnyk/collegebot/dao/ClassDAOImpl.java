package com.pasichnyk.collegebot.dao;

import com.pasichnyk.collegebot.Entity.Group;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDAOImpl implements ClassDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllClass() {
        Session session = entityManager.unwrap(Session.class);

        Query<Group> query = session.createQuery("from Group", Group.class);
        List<Group> allClass = query.getResultList();

        return allClass;
    }
}
