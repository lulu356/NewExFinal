package com.example.newex.HotelDB;

import java.util.Date;

public class Message {
    public String message;
    public String id;

    public Message() {
    }

    public Message(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
