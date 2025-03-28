package com.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
