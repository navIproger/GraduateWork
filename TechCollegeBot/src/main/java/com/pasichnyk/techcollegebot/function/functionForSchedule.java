package com.pasichnyk.techcollegebot.function;

import com.pasichnyk.techcollegebot.Entity.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class functionForSchedule {

    private LocalDateTime currentTime;
    List<Schedule> scheduleList;

    public String createStringWithSchedule(List<Schedule> schedules, int position){
        scheduleList = schedules;
        scheduleList.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                return o1.getTimeStart().compareTo(o2.getTimeStart());
            }
        });

        StringBuilder daySchedule = new StringBuilder("\uD83D\uDCC5" + "\n\n");

        int day = LocalDateTime.now().getDayOfWeek().getValue();
        if (day > 5){
            day = 5;
        }

        int extraPosition = 1;
        if (position % 2 == 0){
            extraPosition = 2;
        }

        for (Schedule schedule : scheduleList){
            int positionOfWeek = schedule.getPositionOfWeek();
            int dayOfWeek = schedule.getDayOfWeek();

            if (dayOfWeek == day && (positionOfWeek == position || positionOfWeek == 7 || positionOfWeek == extraPosition)){
                daySchedule.append((schedule));
            }
        }
        return daySchedule.toString();
    }
    public String createStringWithSchedule(List<Schedule> schedules, int position, int day){
        scheduleList = schedules;
        scheduleList.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                return o1.getTimeStart().compareTo(o2.getTimeStart());
            }
        });

        StringBuilder daySchedule = new StringBuilder("\uD83D\uDCC5" + "\n\n");

        int extraPosition = 1;
        if (position % 2 == 0){
            extraPosition = 2;
        }

        for (Schedule schedule : scheduleList){
            int positionOfWeek = schedule.getPositionOfWeek();
            int dayOfWeek = schedule.getDayOfWeek();

            if (dayOfWeek == day && (positionOfWeek == position || positionOfWeek == 7 || positionOfWeek == extraPosition)){
                daySchedule.append((schedule));
            }
        }
        return daySchedule.toString();
    }
    public int getNumeratorOrDenominator(){
        int counter = 1;

        currentTime = LocalDateTime.now();
        LocalDateTime customTime = LocalDateTime.of(2023, 9, 4, 0, 0);
        int currentDay = currentTime.getDayOfYear();
        int customDay = customTime.getDayOfYear();

        while (currentDay >= customDay){
            counter++;
            currentDay -= 7;
        }

        if (counter % 4 == 0 || counter == 1){
            return 3;
        } else if (counter % 4 == 1 || counter == 2) {
            return 4;
        } else if (counter % 4 == 2 || counter == 3) {
            return 5;
        } else {
            return 6;
        }
    }
}
