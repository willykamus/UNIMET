package com.ching.frankproject.dao;

import com.ching.frankproject.model.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventsDao {

    private ArrayList<Event> eventsList = new ArrayList<>();

    public EventsDao() {

        eventsList.add(new Event("Presentacion de proyecto",new GregorianCalendar(2019, Calendar.JULY,9).getTime(), "Examen"));
        eventsList.add(new Event("Examen Ingles IV",new GregorianCalendar(2019, Calendar.JULY,15).getTime(), "Examen"));
        eventsList.add(new Event("Natalicio de Simon Bolivar",new GregorianCalendar(2019, Calendar.JULY,24).getTime(), "Feriado"));
        eventsList.add(new Event("Dia de la resistencia indigena",new GregorianCalendar(2019, Calendar.OCTOBER,12).getTime(),"Feriado"));
        eventsList.add(new Event("Noche buena",new GregorianCalendar(2019, Calendar.DECEMBER,24).getTime(),"Feriado"));
        eventsList.add(new Event("Dia de Navidad",new GregorianCalendar(2019, Calendar.DECEMBER,25).getTime(),"Feriado"));
        eventsList.add(new Event("Fin de año",new GregorianCalendar(2019, Calendar.DECEMBER,31).getTime(),"Feriado"));

    }

    public ArrayList<Event> getAllEvents() {

        return eventsList;

    }

    public ArrayList<Event> getEventByType(String type) {

        ArrayList<Event> temp = new ArrayList<>();

        for (Event event: eventsList) {

            if (event.getType().equals(type)) {

                temp.add(event);

            }

        }

        return temp;

    }

}
