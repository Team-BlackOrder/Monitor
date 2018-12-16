package org.example.alert.api;

import com.google.inject.Inject;
import org.example.alert.api.Sensors.SensorData;
import org.example.user.api.User;


public class Alert
{
    private String alertId;
    private SensorData sensor;
    private User user;


    @Inject
    public Alert(SensorData sensor,User user){
        //constructor level dependency injection

        this.sensor = sensor;
        this.user = user;
        alertId = "alert001";
    }

    public Alert(String alertId, SensorData sensor, User user)
    {
        this.alertId = alertId;
        this.sensor = sensor;
        this.user = user;
    }

    public String getAlertId()
    {
        return alertId;
    }

    public void setAlertId(String alertId)
    {
        this.alertId = alertId;
    }

    public SensorData getSensor()
    {
        return sensor;
    }

    public void setSensor(SensorData sensor)
    {
        this.sensor = sensor;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
