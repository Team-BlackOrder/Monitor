package org.example.alert.impl;

import org.example.alert.api.Alert;
import org.example.alert.api.Sensors.SensorData;
import org.example.user.api.User;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class MongoDbAlertRepository implements AlertRepository {

    Map<String,Map.Entry<SensorData,User>> userMap= new HashMap<>();

    public MongoDbAlertRepository(){

    }

    @Override
    public Alert getAlert(String id) {
        if(userMap.containsKey(id)){
            Map.Entry entry = userMap.get(id);
            return new Alert(id,(SensorData)entry.getKey(),(User)entry.getValue());
        }
        return null;
    }

    @Override
    public void storeAlert(Alert alert) {
        userMap.put(alert.getAlertId(),new AbstractMap.SimpleEntry(alert.getSensor(),alert.getUser()));

    }
}
