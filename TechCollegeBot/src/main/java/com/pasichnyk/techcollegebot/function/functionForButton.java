package com.pasichnyk.techcollegebot.function;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.Entity.Group;
import com.pasichnyk.techcollegebot.service.ChooseService;
import com.pasichnyk.techcollegebot.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
public class functionForButton {

    @Autowired
    private GroupService groupService;
    @Autowired
    private ChooseService chooseService;

    public InlineKeyboardMarkup getMarkupGroup(String chatId){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        for (Choose choose : chooseService.getChooseByChatId(chatId)){
            rowsInline.add(List.of(getButton(choose.getGroup().getName(), choose.getGroup().getName())));
        }

        rowsInline.add(List.of(getButton("Додати групу", "add")));
        markup.setKeyboard(rowsInline);

        return markup;
    }

    public InlineKeyboardMarkup getMarkupDay(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

        rowInline1.add(getButton("ПН", "1"));
        rowInline1.add(getButton("ВТ", "2"));
        rowInline1.add(getButton("СР", "3"));
        rowInline1.add(getButton("ЧТ", "4"));
        rowInline1.add(getButton("ПТ", "5"));

        rowsInline.add(rowInline1);
        rowsInline.add(List.of(getButton("Видалити", "deleteGroup")));
        rowsInline.add(List.of(getButton("Назад", "back")));

        markup.setKeyboard(rowsInline);

        return markup;
    }

    public boolean addGroup(String groupName, String chatId){
        Group group = groupService.getGroupByName(groupName);

        if(group != null && (chooseService.getChooseByChatIdAndGroup(chatId, group) == null)){
            chooseService.addChoose(new Choose(chatId, group));
            return true;
        }
        return false;
    }

    public void deleteGroup(String groupName, String chatId){
        Group group = groupService.getGroupByName(groupName);
        if(group != null){
            chooseService.deleteChooseByChatId(chatId, group);
        }
    }

    private InlineKeyboardButton getButton(String name, String data){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(name);
        button.setCallbackData(data);
        return button;
    }
}
