package com.pasichnyk.collegebot.function;

import com.pasichnyk.collegebot.Entity.Schedule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ForSchedule {

    public String createStringWithSchedule(List<Schedule> schedules, int position){
        List<Schedule> scheduleList = schedules;
        scheduleList.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                return o1.getTimeStart().compareTo(o2.getTimeStart());
            }
        });

        StringBuilder monday = new StringBuilder("Понеділок\n\n");
        StringBuilder tuesday = new StringBuilder("Вівторок\n\n");
        StringBuilder wednesday = new StringBuilder("Середа\n\n");
        StringBuilder thursday = new StringBuilder("Четвер\n\n");
        StringBuilder friday = new StringBuilder("П'ятниця\n\n");
        StringBuilder saturday = new StringBuilder("Субота\n\n");

        for (Schedule schedule : scheduleList){
            if (schedule.getDayOfWeek() == 1 && schedule.getPositionOfWeek() == position){
                monday.append((schedule));
            } else if (schedule.getDayOfWeek() == 2 && schedule.getPositionOfWeek() == position){
                tuesday.append(schedule);
            } else if (schedule.getDayOfWeek() == 3 && schedule.getPositionOfWeek() == position){
                wednesday.append(schedule);
            } else if (schedule.getDayOfWeek() == 4 && schedule.getPositionOfWeek() == position){
                thursday.append(schedule);
            } else if (schedule.getDayOfWeek() == 5 && schedule.getPositionOfWeek() == position){
                friday.append(schedule);
            } else if (schedule.getDayOfWeek() == 6 && schedule.getPositionOfWeek() == position){
                saturday.append(schedule);
            }
        }
        return (monday + "***************\n\n" + tuesday +
                "***************\n\n" + wednesday + "***************\n\n" +
                thursday + "***************\n\n" + friday + "***************\n\n" + saturday);
    }

    private int getNumeratorOrDenominator(){
        return 1;
    }
}
