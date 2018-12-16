package org.example.notification.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.notification.api.Notification;
import org.example.notification.api.NotificationService;

import java.util.concurrent.CompletableFuture;

public class NotificationImpl implements NotificationService {

    private String divider = "\n--------------------------------------------------------------------------------------\n";
    @Override
    public ServiceCall<NotUsed, Done> sendEmail() {

        return request -> {
            System.out.println(divider);
            System.out.println("Sending Email to notify user......." );
            System.out.println(divider);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, Done> sendSms() {

        return request -> {
            System.out.println(divider);
            System.out.println("Sending SMS to notify user.......");
            System.out.println(divider);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }
}
