package org.example.hello.impl;

import akka.Done;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.example.Product;
import org.example.ProductService;
import org.example.hello.api.HelloService;
import org.example.hello.api.Order;

/**
 * Implementation of the HelloService.
 */
public class HelloServiceImpl implements HelloService {

  private ProductService productService;

  @Inject
  public HelloServiceImpl(ProductService productService) {
    this.productService = productService;
  }


    @Override
    public ServiceCall<Order, Done> placeOrder() {
      return request -> {
        //calculate the total product cost before save it
        double totalCost=0;
        for (String x:request.getProductIds()){
          try{
            Product product = productService.getProductById(x).invoke().toCompletableFuture().get();
            totalCost += product.getUnitPrice();
          } catch (InterruptedException e){
            e.printStackTrace();
          }catch (ExecutionException e){
            e.printStackTrace();
          }
        }
        //calculate total cost
        System.out.println("Total order cost is : " + totalCost);
        //save the order in order repository
        System.out.println("Saving the order to db");
        return CompletableFuture.completedFuture(Done.getInstance());
      };
    }

    @Override
    public Descriptor descriptor(){
      return null;
    }
}
