package org.example.user.impl;

import com.google.inject.ImplementedBy;
import org.example.user.api.User;

@ImplementedBy(MongoDBUserRepository.class)
public interface UserRepository {
    User getUserById(String id);
    void addUser(User user);
    void removeUser(String id);
    User getUserBySensorId(String sensorId);
}
