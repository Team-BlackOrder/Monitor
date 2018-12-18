package org.example.alert.api;


import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.alert.api.Sensors.TemperatureData;


import static com.lightbend.lagom.javadsl.api.Service.pathCall;


public interface AlertService extends Service
{
    ServiceCall<TemperatureData, Done> triggerAlert();
    ServiceCall<NotUsed,Done> setAlertThreshold(String threshold);


    @Override
    default Descriptor descriptor()
    {
        return Service.named("alert").withCalls(
                pathCall("/api/alert", this::triggerAlert),
                pathCall("/api/alertThreshold/:threshold",this::setAlertThreshold)).withAutoAcl(true);
    }




}
