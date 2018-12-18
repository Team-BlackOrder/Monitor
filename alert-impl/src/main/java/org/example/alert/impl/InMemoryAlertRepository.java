package org.example.alert.impl;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.example.alert.api.Alert;
import org.example.alert.api.Sensors.SensorData;
import org.example.user.api.User;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAlertRepository implements AlertRepository
{
//    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//    DB database = mongoClient.getDatabase("TheDatabaseName");
    Map<String, Map.Entry<SensorData, User>> userMap = new HashMap<>();
    private String divider = "\n--------------------------------------------------------------------------------------\n";

    public InMemoryAlertRepository()
    {

    }

//    @Override
//    public Alert getAlert()
//    {
////        if (userMap.containsKey(id))
////        {
////            Map.Entry entry = userMap.get(id);
////            return new Alert(id, (SensorData) entry.getKey(), (User) entry.getValue());
////        }
//        return new Alert();
//    }

    @Override
    public void storeAlert(Alert alert)
    {
        userMap.put(alert.getAlertId(), new AbstractMap.SimpleEntry(alert.getSensor(), alert.getUser()));
        System.out.println(divider);
        System.out.println("Sensor Id: " + alert.getSensor().getSensorId() + "\nTime: " + alert.getSensor().getTimeStamp() + "\nReading: " + alert.getSensor().getReading());

    }

    @Override
    public void storeThreshold(String threshold)
    {

    }

    @Override
    public double getThreshold()
    {
        return 0;
    }
}
