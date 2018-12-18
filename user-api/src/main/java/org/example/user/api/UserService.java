package org.example.user.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.pathCall;

public interface UserService extends Service {
    ServiceCall<NotUsed,User>getUserById(String id);
    ServiceCall<User, Done> addUser();
    ServiceCall<NotUsed,User>getUserBySensorId(String sensorId);
    ServiceCall<NotUsed,Done> removeUser(String id);

    @Override
    default Descriptor descriptor() {
        return Service.named("user").withCalls(
                pathCall("/api/user/:id",this::getUserById),
                pathCall("/api/addUser",this::addUser),
                pathCall("/api/sensor/:sensorId",this::getUserBySensorId),
                pathCall("/api/removeUser/:id",this::removeUser)
        ).withAutoAcl(true);
    }


}
