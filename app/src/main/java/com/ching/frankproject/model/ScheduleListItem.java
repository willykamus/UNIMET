package com.ching.frankproject.model;

public class ScheduleListItem {

    private String startHour;
    private String endHour;
    private String room;
    private String weekDay;
    private String subjectName;
    private String subjectCode;

    public ScheduleListItem(String startHour, String endHour, String room, String weekDay, String subjectName, String subjectCode) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.room = room;
        this.weekDay = weekDay;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
