package org.example.alert.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.alert.api.Alert;
import org.example.alert.api.AlertService;
import org.example.alert.api.Sensors.SensorData;
import org.example.alert.api.Sensors.TemperatureData;
import org.example.notification.api.NotificationService;
import org.example.user.api.User;
import org.example.user.api.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AlertImpl implements AlertService
{

    private AlertRepository alertRepository;
    private double alertThreshold;
    private final UserService userService;
    private final NotificationService notificationService;



    @Inject
    public AlertImpl(AlertRepository userRepository,UserService userService,NotificationService notificationService){

        this.alertRepository = userRepository;
        this.userService = userService;
        this.notificationService = notificationService;
    }



    @Override
    public ServiceCall<TemperatureData, Done> triggerAlert() {
        System.out.println("storeAlert method is called with id : ");
        return request -> {
            if(request.getReading() > alertThreshold)
            {
                try
                {
                    User user =  userService.getUserBySensorId(request.getSensorId()).invoke().toCompletableFuture().get();
                    Alert alert = new Alert(request, user);
                    alertRepository.storeAlert(alert);

                    switch (user.getPreferredAlertMethod())
                    {
                        case "sms":
                            notificationService.sendSms();
                        case "email":
                            notificationService.sendEmail();
                        default:
                            System.out.println("Invalid notification method");
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, Done> setAlertThreshold(String threshold)
    {
        alertThreshold = Double.parseDouble(threshold);
        return request -> CompletableFuture.completedFuture(Done.getInstance());

    }



    @Override
    public ServiceCall<NotUsed, NotUsed> test()
    {
        return null;
    }


}
