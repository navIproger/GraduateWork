package com.pasichnyk.techcollegebot.dao;

import com.pasichnyk.techcollegebot.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDAO extends JpaRepository<Group, Integer> {

    public List<Group> findAll();

    public Group findByName(String name);
}
