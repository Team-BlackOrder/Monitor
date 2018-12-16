package org.example.alert.api.Sensors;

import java.time.LocalDateTime;

public class TemperatureData implements SensorData
{
    private String sensorId;
    private LocalDateTime timeStamp;
    private double readingInCelcius;


    @Override
    public String getSensorId()
    {
        return sensorId;
    }

    public void setSensorId(String sensorId)
    {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public double getReading()
    {
        return readingInCelcius;
    }

    public void setReading(double readingInCelcius)
    {
        this.readingInCelcius = readingInCelcius;
    }
}
