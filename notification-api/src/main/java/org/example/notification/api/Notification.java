package org.example.notification.api;

public class Notification {

    private String body;

    public Notification(){

    }

    public Notification(String body){
        this.body=body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
