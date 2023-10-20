package com.pasichnyk.techcollegebot.bot;


import com.pasichnyk.techcollegebot.function.functionForButton;
import com.pasichnyk.techcollegebot.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TechCollegeBot extends TelegramLongPollingBot {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private functionForButton functionForButton;
    @Autowired
    private com.pasichnyk.techcollegebot.function.functionForClass functionForClass;
    @Autowired
    private com.pasichnyk.techcollegebot.function.functionForSchedule functionForSchedule;

    private boolean adds = false;
    private String nameGroup = null;

    public String getBotToken() {
        return "6302338815:AAFcN25ObYsCLXsFswIkrAkB_5-AuoPXsRM";
    }

    public String getBotUsername() {
        return "techcollege_bot";
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);

            if (adds){
                if (!functionForButton.addGroup(message, chatId)){
                    sendMessage.setText("Невідомий код групи, повторіть спробу, наприклад 11-ПЗ, або група вже вибрана");
                }else {
                    sendMessage.setText("Розклад групи:\n");
                    sendMessage.setReplyMarkup(functionForButton.getMarkupGroup(chatId));
                }
                adds = false;
            } else {
                if (message.startsWith("/start")) {
                    sendMessage.setText("Вас вітає, телеграм бот ВСП Технічного Фахового Коледжу Національного Університету 'Львівська Політехніка'");
                } else if (message.startsWith("/schedule")) {
                    sendMessage.setReplyMarkup(functionForButton.getMarkupGroup(chatId));
                    sendMessage.setText("Розклад:\n");
                }
            }
            try {
                if (sendMessage.getText() != null) {
                    execute(sendMessage);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String chatId = callbackQuery.getMessage().getChatId().toString();
            String data = callbackQuery.getData();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);

            EditMessageText editMessage = new EditMessageText();
            editMessage.setChatId(callbackQuery.getMessage().getChatId().toString());
            editMessage.setMessageId(callbackQuery.getMessage().getMessageId());
            editMessage.setReplyMarkup(functionForButton.getMarkupDay());

            if (data.equals("add")){
                sendMessage.setText("Відправ назву групи у такому форматі '41-КІ'");
                adds = true;
            } else if (data.equals("deleteGroup")) {
                functionForButton.deleteGroup(nameGroup ,chatId);
                editMessage.setText("Розклад:\n");
                editMessage.setReplyMarkup(functionForButton.getMarkupGroup(chatId));
            } else if(data.equals("1") || data.equals("2") || data.equals("3") || data.equals("4") || data.equals("5")){
                editMessage.setText(functionForSchedule.createStringWithSchedule(scheduleService.getGroupSchedule(functionForClass.getClassByName(nameGroup)), functionForSchedule.getNumeratorOrDenominator(), Integer.parseInt(data)));
            } else if (data.equals("back")) {
                editMessage.setReplyMarkup(functionForButton.getMarkupGroup(chatId));
                editMessage.setText("Розклад:\n");
            } else if (!data.equals("")){
                nameGroup = data;
                editMessage.setText(functionForSchedule.createStringWithSchedule(scheduleService.getGroupSchedule(functionForClass.getClassByName(data)), functionForSchedule.getNumeratorOrDenominator()));
            }

            try {
                if (sendMessage.getText() != null) {
                    execute(sendMessage);
                }else {
                    execute(editMessage);
                }
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }
}
