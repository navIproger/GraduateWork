package com.pasichnyk.techcollegebot.dao;

import com.pasichnyk.techcollegebot.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

    public List<Teacher> findAll();
}
