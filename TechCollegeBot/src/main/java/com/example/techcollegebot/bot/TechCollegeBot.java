package com.example.techcollegebot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TechCollegeBot extends TelegramLongPollingBot {

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

            if(message.startsWith("/start")){
                sendMessage.setText("Вас вітає, телеграм бот ВСП Технічного Фахового Коледжу Національного Університету 'Львівська Політехніка'");
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }

    }
}
