package com.example.productService.Repository;

import com.example.productService.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// for connecting to the mongodb repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
