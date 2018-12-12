package org.example;


import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

public interface ProductService extends Service {
    ServiceCall<NotUsed,Product> getProductById(String id); //method signature
    ServiceCall<Product,Done> addProduct();

    @Override
    default Descriptor descriptor(){
        return named("product").withCalls(
                pathCall("/api/product/:id",this::getProductById),
                pathCall("/api/product",this::addProduct)
        ).withAutoAcl(true);
    }
}
