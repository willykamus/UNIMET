package com.ching.frankproject.dao;

import com.ching.frankproject.model.ScheduleListItem;

import java.util.ArrayList;

public class ScheduleDao {

    private ArrayList<Object> itemArrayList = new ArrayList<>();

    public ScheduleDao(){

        itemArrayList.add("Monday");
        itemArrayList.add(new ScheduleListItem("10:30",
                "12:00", "EMG 23","Monday",
                "Compresion","FBTHU02"));
        itemArrayList.add(new ScheduleListItem("17:30",
                "19:00", "SL-005","Monday",
                "Tecnicas de Gestion","FBTCE04"));
        itemArrayList.add("Tuesday");
        itemArrayList.add(new ScheduleListItem("10:30",
                "12:00", "A2-314","Tuesday",
                "Ingles IV","FBTCE04"));
        itemArrayList.add(new ScheduleListItem("17:30",
                "12:00", "A2-314","Tuesday",
                "Ingles IV","FBTCE04"));
        itemArrayList.add("Wednesday");
        itemArrayList.add(new ScheduleListItem("08:45",
                "10:15", "A2-208","Wednesday",
                "Aprendiendo","FBTIE03"));
        itemArrayList.add(new ScheduleListItem("17:30",
                "19:00", "SL-005","Wednesday",
                "Tecnicas de Gestion","FBTCE04"));
        itemArrayList.add(new ScheduleListItem("18:30",
                "19:00", "SL-005","Wednesday",
                "Tecnicas de Gestion","FBTCE04"));
        itemArrayList.add("Thursday");
        itemArrayList.add(new ScheduleListItem("10:30",
                "12:00", "A1-314","Thursday",
                "Ingles IV","FBTIN04"));

    }

    public ArrayList<Object> getItemArrayList() {
        return itemArrayList;
    }
}
