package org.example.alert.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.alert.api.Alert;
import org.example.alert.api.AlertService;
import org.example.alert.api.Sensors.SensorData;
import org.example.user.api.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class AlertImpl implements AlertService
{

    private AlertRepository alertRepository;
    private double alertThreashold;
    private final UserService userService;



    @Inject
    public AlertImpl(AlertRepository userRepository,UserService userService){

        this.alertRepository = userRepository;
        this.userService = userService;
    }



    @Override
    public ServiceCall<SensorData, Done> triggerAlert() {
        System.out.println("storeAlert method is called with id : ");
        return request -> {
            if(request.getReading() > alertThreashold)
            {
                Alert alert = new Alert(request,userService.getUserById(request.getSensorId()))
                alertRepository.storeAlert();
            }
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, Done> setAlertThreshold(String threshold)
    {
        alertThreashold = Double.parseDouble(threshold);
        return request -> CompletableFuture.completedFuture(Done.getInstance());

    }


}
