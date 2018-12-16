package org.example.alert.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.alert.api.AlertService;
import org.example.notification.api.NotificationService;
import org.example.user.api.UserService;


public class AlertModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {

        bindService(AlertService.class, AlertImpl.class);
        bindClient(UserService.class);
        bindClient(NotificationService.class);
    }
}
