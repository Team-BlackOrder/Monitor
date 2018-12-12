package org.example.notification.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.notification.api.NotificationService;

public class NotificationModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    public void configure(){
        bindService(NotificationService.class,NotificationImpl.class);
    }
}
