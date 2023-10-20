package com.pasichnyk.techcollegebot;

import com.pasichnyk.techcollegebot.Entity.Choose;
import com.pasichnyk.techcollegebot.bot.TechCollegeBot;
import com.pasichnyk.techcollegebot.service.ChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TechCollegeBotApplication implements CommandLineRunner {

    @Autowired
    private TechCollegeBot techCollegeBot;

    public static void main(String[] args) {
        SpringApplication.run(TechCollegeBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(techCollegeBot);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
