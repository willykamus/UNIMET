package com.ching.frankproject.model;

import java.util.Calendar;
import java.util.Date;

public class Event {

    String description;
    Date date;
    Calendar calendar;
    String type;

    public Event(String description, Date date, String type) {
        this.description = description;
        this.date = date;
        this.calendar = Calendar.getInstance();
        this.type = type;
        calendar.setTime(date);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return this.type;
    }

    public int getDayOfEvent(){

         return  calendar.get(Calendar.DAY_OF_MONTH);
    }

    public String getDayOfTheWeek(){

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {
            case 2:
                return "Lunes";
            case 3:
                return "Martes";
            case 4:
                return "Miercoles";
            case 5:
                return "Jueves";
            case 6:
                return "Viernes";
            case 7:
                return "Sabado";
            case 1:
                return "Domingo";
                default:
                    return "";

        }
    }
    public int getMonthOfEvent(){
        return  calendar.get(Calendar.MONTH);
    }

    public int getYearOfEvent(){
        return calendar.get(Calendar.YEAR);
    }


}
