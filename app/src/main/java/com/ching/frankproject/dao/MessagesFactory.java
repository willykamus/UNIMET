package com.ching.frankproject.dao;

public class MessagesFactory {

    private static MessagesDao instance = new MessagesDao();

    public static MessagesDao getMessageDao() {
        return instance;
    }
}
