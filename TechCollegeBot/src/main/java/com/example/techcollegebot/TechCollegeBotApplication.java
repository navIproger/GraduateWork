package com.example.techcollegebot;

import com.example.techcollegebot.Entity.Schedule;
import com.example.techcollegebot.bot.TechCollegeBot;
import com.example.techcollegebot.service.ScheduleService;
import com.example.techcollegebot.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

@SpringBootApplication
public class TechCollegeBotApplication implements CommandLineRunner {

    @Autowired
    private ScheduleService scheduleService;
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TechCollegeBot());
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }



        SpringApplication.run(TechCollegeBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Schedule> list = scheduleService.getAllSchedule();
        System.out.println(list);
    }
}
