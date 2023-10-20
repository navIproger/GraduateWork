package com.pasichnyk.techcollegebot.service;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.dao.ChooseDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChooseService {

    @Autowired
    private ChooseDAO chooseDAO;

    public List<Choose> getAllChooses() {
        return chooseDAO.findAll();
    }

    public List<Choose> getChooseByChatId(String chatId) { return chooseDAO.findAllByChatId(chatId);}

    public Choose getChooseByChatIdAndGroup(String chatId, Group group){
        return chooseDAO.findByChatIdAndGroup(chatId, group);
    }

    public Choose addChoose(Choose choose) {
        return chooseDAO.save(choose);
    }

    public boolean check(String chatId, Group group){
        return chooseDAO.getChooseByChatIdAndGroup(chatId, group);
    }

    @Transactional
    public void deleteChooseByChatId(String chatId, Group group) {
        chooseDAO.deleteByChatIdAndGroup(chatId, group);
    }
}
