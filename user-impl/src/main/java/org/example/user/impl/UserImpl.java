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
        System.out.println("get user by id method is called with id : "+id);
        return request -> CompletableFuture.completedFuture(userRepository.getUser(id));

    }

    @Override
    public ServiceCall<User, Done> addUser() {
        System.out.println("addUser method is called with id : ");
        return request -> {
            //save the product in database
            ////System.out.println(request.getId());
            //System.out.println(request.getDescription());
            //System.out.println(request.getUnitPrice());

            userRepository.addUser(request);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }
}
