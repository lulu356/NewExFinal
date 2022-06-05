package com.example.newex.HotelDB;

import java.util.Date;

public class Message {
    public String idmess, generatedmessId ,MessageTime, UserId, User, TextMessage;

    public Message(Object o, String mUsername, String s) {
    }

    public String getIdmess() {
        return idmess;
    }

    public void setIdmess(String idmess) {
        this.idmess = idmess;
    }

    public String getGeneratedmessId() {
        return generatedmessId;
    }

    public void setGeneratedmessId(String generatedmessId) {
        this.generatedmessId = generatedmessId;
    }

    public String getMessageTime() {
        return MessageTime;
    }

    public void setMessageTime(String messageTime) {
        MessageTime = messageTime;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getTextMessage() {
        return TextMessage;
    }

    public void setTextMessage(String textMessage) {
        TextMessage = textMessage;
    }

    public Message(String idmess, String generatedmessId, String MessageTime, String UserId, String User, String TextMessage) {
        this.idmess = idmess;
        this.generatedmessId = generatedmessId;
        this.MessageTime = MessageTime;
        this.UserId = UserId;
        this.User = User;
        this.TextMessage = TextMessage;
    }}
