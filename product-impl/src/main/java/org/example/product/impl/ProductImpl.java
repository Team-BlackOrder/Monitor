package org.example.product.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.example.ProductService;
import org.example.Product;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class ProductImpl implements ProductService {

    //This field has been injected by google guice framework
    private ProductRepository productRepository;

    @Inject
    public ProductImpl(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    @Override
    public ServiceCall<NotUsed, Product> getProductById(String id) {

        ////System.out.println("get product by id method is called with id : "+id);
        //ProductRepository productRepository=new InMemeryProductRepository();
        return request -> CompletableFuture.completedFuture(productRepository.getProduct(id));
    }

    @Override
    public ServiceCall<Product, Done> addProduct() {


        return request -> {
            //save the product in database
            //System.out.println(request.getId());
            //System.out.println(request.getDescription());
            //System.out.println(request.getUnitPrice());

            productRepository.addProduct(request);
            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }
}
