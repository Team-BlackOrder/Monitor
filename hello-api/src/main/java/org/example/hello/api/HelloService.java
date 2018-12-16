package org.example.hello.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import akka.Done;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.ForkJoinTask;

public interface HelloService extends Service
{


  ServiceCall<Order, Done> placeOrder();

  @Override
  default Descriptor descriptor()
  {
    // @formatter:off
    return named("hello").withCalls(
            pathCall("/api/order", this::placeOrder)
    ).withAutoAcl(true);
    // @formatter:on
  }

}
