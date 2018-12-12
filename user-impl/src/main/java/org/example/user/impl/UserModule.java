package org.example.user.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.user.api.UserService;

public class UserModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {

        bindService(UserService.class, UserImpl.class);
    }
}
