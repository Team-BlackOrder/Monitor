package org.example.alert.api.Sensors;

import java.time.LocalDateTime;

public interface SensorData
{

    String getSensorId();
    LocalDateTime getTimeStamp();
    double getReading();

    void setSensorId(String sensorId);
    void setTimeStamp(LocalDateTime timeStamp);
    void setReading(double readingInCelcius);


}
