package com.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
