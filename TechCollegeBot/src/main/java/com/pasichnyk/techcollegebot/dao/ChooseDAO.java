package com.pasichnyk.techcollegebot.dao;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChooseDAO extends JpaRepository<Choose, String> {

    public List<Choose> findAll();

    public List<Choose> findAllByChatId(String chatId);

    public Choose findByChatIdAndGroup(String chatId, Group group);

    public Choose save(Choose choose);

    public void deleteByChatIdAndGroup(String chatId, Group group);

    public boolean getChooseByChatIdAndGroup(String chatId, Group group);
}
