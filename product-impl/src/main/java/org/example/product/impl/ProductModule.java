package org.example.product.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import org.example.ProductService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class ProductModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {

    bindService(ProductService.class, ProductImpl.class);
  }
}
