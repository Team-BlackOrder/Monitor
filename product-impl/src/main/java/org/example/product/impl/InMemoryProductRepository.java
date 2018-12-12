package org.example.product.impl;

import org.example.Product;

import java.util.HashMap;
import  java.util.Map;

public class InMemoryProductRepository implements  ProductRepository {

    Map<String,Product> productMap= new HashMap<>();

    public InMemoryProductRepository(){
        Product product1=new Product("111","Nokia mobile phone",10000);

        Product product2=new Product("222","water bottle",200000);

        productMap.put("111",product1);
        productMap.put("222",product2);
    }

    @Override
    public Product getProduct(String id) {

        if(productMap.containsKey(id)){
            return productMap.get(id);
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(),product);

    }
}
