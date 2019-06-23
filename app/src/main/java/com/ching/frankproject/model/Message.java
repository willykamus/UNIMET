package com.ching.frankproject.model;

import java.util.Comparator;
import java.util.Date;

public class Message implements Comparable {

    private String sender;
    private String recipient;
    private String text;
    private Date dateStamp;

    public Message(String sender, String recipient, String text, Date dateStamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        this.dateStamp = dateStamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public boolean compareTo(Message o) {

        Date date = ((Message) o).getDateStamp();

        return date.before(this.dateStamp);

    }

    @Override
    public int compareTo(Object o) {
        int date = (int)((Message)o).getDateStamp().getTime() / 1000;
        int thisDate = (int) this.getDateStamp().getTime() / 1000;

        return date - thisDate;
    }
}
