package com.example.superman.bigmaptest;

/**
 * Created by Superman on 2018/3/22.
 */

public class MessageEvent {
    private String message;

    public  MessageEvent(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
