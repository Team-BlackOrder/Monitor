package org.example.user.impl;

import com.google.inject.ImplementedBy;
import org.example.user.api.User;

@ImplementedBy(InMemoryUserRepository.class)
public interface UserRepository {
    User getUser(String id);
    void addUser(User user);
}