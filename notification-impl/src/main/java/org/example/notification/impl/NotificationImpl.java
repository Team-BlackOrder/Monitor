package org.example.notification.impl;

import akka.Done;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.notification.api.Notification;
import org.example.notification.api.NotificationService;

import java.util.concurrent.CompletableFuture;

public class NotificationImpl implements NotificationService {

    Notification notification=new Notification();

    @Override
    public ServiceCall<Notification, Done> sendEmail() {

        return request -> {
            notification=request;
            System.out.println("Sending Email......."+notification.getBody());
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

    @Override
    public ServiceCall<Notification, Done> sendSms() {

        return request -> {
            notification=request;
            System.out.println("Sending SMS......."+notification.getBody());
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }
}
