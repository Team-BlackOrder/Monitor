package org.example.notification.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.named;

public interface NotificationService extends Service {

    ServiceCall<NotUsed, Done> sendEmail();
    ServiceCall<NotUsed, Done> sendSms();

    @Override
    default Descriptor descriptor(){
        return named("notification").withCalls(
                pathCall("/api/notification/email",this::sendEmail),
                pathCall("/api/notification/sms",this::sendSms)
        ).withAutoAcl(true);
    };
}
