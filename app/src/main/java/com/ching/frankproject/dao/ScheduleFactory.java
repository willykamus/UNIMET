package com.ching.frankproject.dao;

public class ScheduleFactory {

    private static ScheduleDao scheduleDao= new ScheduleDao();

    public static ScheduleDao getScheduleDao(){
        return scheduleDao;
    }

}
