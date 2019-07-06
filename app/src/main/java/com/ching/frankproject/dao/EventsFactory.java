package com.ching.frankproject.dao;

public class EventsFactory {

    private static EventsDao instance = new EventsDao();

    public static EventsDao getEventsDao(){
        return instance;
    }
}
