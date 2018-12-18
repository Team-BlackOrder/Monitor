package org.example.user.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.user.api.User;
import org.example.user.api.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class UserImpl implements UserService {

    private UserRepository userRepository;

    @Inject
    public UserImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public ServiceCall<NotUsed, User> getUserById(String id) {

        System.out.println("\nGetting User ID : "+ id);

        return request -> CompletableFuture.completedFuture(userRepository.getUserById(id));
    }

    @Override
    public ServiceCall<User, Done> addUser() {
        System.out.println("\nAdding A new User");
        return request -> {
            userRepository.addUser(request);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, User> getUserBySensorId(String sensorId) {
        System.out.println("Getting the user with sensor ID :"+ sensorId);
        return request -> CompletableFuture.completedFuture(userRepository.getUserBySensorId(sensorId));
    }

    @Override
    public ServiceCall<NotUsed, Done> removeUser(String id)
    {
        return request -> {
            userRepository.removeUser(id);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }
}
