package org.example.user.impl;

import org.example.user.api.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    Map<String,User> userMap= new HashMap<>();

    public InMemoryUserRepository(){
        User user1=new User("1","VJ","0765454","nsbd@sjds.com");

        User user2=new User("2","Maheshi","01546646","bsdv@nbsdv.com");

        userMap.put("1",user1);
        userMap.put("2",user2);
    }

    @Override
    public User getUser(String id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(),user);

    }
}