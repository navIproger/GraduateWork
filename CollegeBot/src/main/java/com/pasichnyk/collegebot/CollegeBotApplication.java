package com.pasichnyk.collegebot;

import com.pasichnyk.collegebot.Entity.Schedule;
import com.pasichnyk.collegebot.bot.CollegeBot;
import com.pasichnyk.collegebot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

@SpringBootApplication
public class CollegeBotApplication extends TelegramLongPollingBot implements CommandLineRunner {

    @Autowired
    private ScheduleService scheduleService;

    private static ScheduleService scheduleServiceCopy;
    public static List<Schedule> schedules;

    public static void main(String[] args) {
        SpringApplication.run(CollegeBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CollegeBotApplication());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
        scheduleServiceCopy = scheduleService;
    }

    public String getBotToken() {
        return "6302338815:AAFcN25ObYsCLXsFswIkrAkB_5-AuoPXsRM";
    }

    public String getBotUsername() {
        return "techcollege_bot";
    }

    public void onUpdateReceived(Update update) {
        schedules = scheduleServiceCopy.getAllSchedule();
        System.out.println(schedules);
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Невідома команда");

            if(message.startsWith("/start")){
                sendMessage.setText("Вас вітає, телеграм бот ВСП Технічного Фахового Коледжу Національного Університету 'Львівська Політехніка'");
            } else if (message.startsWith("/getSchedule")) {
                sendMessage.setText(schedules.toString());
            }


            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }

    }
}
