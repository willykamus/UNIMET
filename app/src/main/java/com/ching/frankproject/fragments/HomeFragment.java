package com.ching.frankproject.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ching.frankproject.R;
import com.ching.frankproject.dao.ScheduleDao;
import com.ching.frankproject.dao.ScheduleFactory;
import com.ching.frankproject.model.ScheduleListItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    private String username;
    private ScheduleDao scheduleDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView welcome = view.findViewById(R.id.welcomeTV);
        TextView nextClassTV = view.findViewById(R.id.nextClassTV);
        TextView timeToNextClassTV = view.findViewById(R.id.timeToNextClassTV);
        TextView ubitacionTV = view.findViewById(R.id.ubicationTV);

        scheduleDao = ScheduleFactory.getScheduleDao();

        ArrayList<ScheduleListItem> dateList = getClassForDay(getCurrentDay());

        ScheduleListItem nextClass = getNextClass(dateList);

        if(nextClass != null){
            nextClassTV.setText(nextClass.getSubjectName());
            String[] location = nextClass.getRoom().split("-");
            ubitacionTV.setText("Edificio: "+ location[0] + " Salon: " + location[1]);
            timeToNextClassTV.setText(String.valueOf(getTimeDifference(nextClass)) + " min");
        } else {
            nextClassTV.setText("No tienes mas clase por hoy");
            ubitacionTV.setText("");
            timeToNextClassTV.setText("");
        }

        Context context = view.getContext();
        SharedPreferences preferences = context.getSharedPreferences(getString(R.string.preference_key),Context.MODE_PRIVATE);
        username = preferences.getString("firstName","Not found!");
        welcome.setText("Bienvenido "+username);

    }

    private String getCurrentDay(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Log.i("Date",simpleDateFormat.format(date));
        return simpleDateFormat.format(date);


    }

    private int getTimeDifference(ScheduleListItem scheduleListItem){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String hour = simpleDateFormat.format(date);
        String[] time = hour.split(":");
        int currentMinutes = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);

        String[] classTime = scheduleListItem.getStartHour().split(":");
        int classTotalMinutes = Integer.valueOf(classTime[0])*60 + Integer.valueOf(classTime[1]);

        return classTotalMinutes - currentMinutes;

    }

    private ArrayList<ScheduleListItem> getClassForDay(String date){

        ArrayList<ScheduleListItem> dateList = new ArrayList<>();

        for(Object object : scheduleDao.getItemArrayList()){
            if(object instanceof ScheduleListItem) {
                if(((ScheduleListItem) object).getWeekDay().equals(date)){
                    dateList.add((ScheduleListItem)object);
                }
            }
        }

        return dateList;

    }

    private ScheduleListItem getNextClass(ArrayList<ScheduleListItem> list){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String hour = simpleDateFormat.format(date);
        String[] time = hour.split(":");
        int currentMinutes = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
        ScheduleListItem index = null;
        int clossestClass = Integer.MAX_VALUE;


        for (ScheduleListItem scheduleListItem : list){
            String[] classTime = scheduleListItem.getStartHour().split(":");
            int classTotalMinutes = Integer.valueOf(classTime[0])*60 + Integer.valueOf(classTime[1]);
            if(classTotalMinutes > currentMinutes){
                int timeDifference = classTotalMinutes - currentMinutes;
                if(timeDifference < clossestClass){
                    index = scheduleListItem;
                    clossestClass = timeDifference;
                }
            }
        }

        return index;

    }

}
