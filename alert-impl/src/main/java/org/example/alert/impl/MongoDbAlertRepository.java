package org.example.alert.impl;

import org.example.alert.api.Alert;
import org.example.user.api.User;

import java.util.HashMap;
import java.util.Map;

public class MongoDbAlertRepository implements AlertRepository {

    Map<String,User> userMap= new HashMap<>();

    public MongoDbAlertRepository(){
        User user1=new User("1","VJ","0765454","nsbd@sjds.com","sms");

        User user2=new User("2","Maheshi","01546646","bsdv@nbsdv.com","email");

        userMap.put("1",user1);
        userMap.put("2",user2);
    }

    @Override
    public User getAlert(String id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public void storeAlert(Alert alert) {
        userMap.put(user.getId(),user);

    }
}
