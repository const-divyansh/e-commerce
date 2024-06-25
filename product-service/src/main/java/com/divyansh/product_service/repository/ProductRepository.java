package com.divyansh.product_service.repository;

import com.divyansh.product_service.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository <Product,String> {
}
