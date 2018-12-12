package org.example.product.impl;

import com.google.inject.ImplementedBy;
import org.example.Product;


@ImplementedBy(InMemoryProductRepository.class)
public interface ProductRepository {

    Product getProduct(String id);

    void addProduct(Product product);
}
