package com.ching.frankproject.dao;

import com.ching.frankproject.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class MessagesDao {

    private ArrayList<Message> messageArrayList = new ArrayList<>();

    public MessagesDao() {

        messageArrayList.add(new Message("Abrahin","Profesor_1","Respondere tu duda durante la clase, Saludo",
                new GregorianCalendar(2019, Calendar.JUNE,15).getTime()));

        messageArrayList.add(new Message("Abrahin","Profesor_2","La solucion a tu problema la puedes encontrar en el capitulo 2 del libro, Saludos",
                new GregorianCalendar(2019, Calendar.JUNE,10).getTime()));

        messageArrayList.add(new Message("William","Profesor_2","La solucion a tu problema la puedes encontrar en el capitulo 2 del libro, Saludos",
                new GregorianCalendar(2019, Calendar.JUNE,10).getTime()));

        messageArrayList.add(new Message("Abrahin","Estudiante_1","Te pase el archivo del proyecto a tu correo, avisame cuando lo veas",
                new GregorianCalendar(2019, Calendar.JUNE,10).getTime()));

    }

    public ArrayList<Message> getMessagesFromUser(String sender) {

        ArrayList<Message> temp = new ArrayList<>();

        for (Object object : messageArrayList) {

            Message message = (Message) object;

            if(message.getSender().equals(sender)) {

                temp.add(message);

            }

        }

        Collections.sort(temp);

        return temp;

    }

}
