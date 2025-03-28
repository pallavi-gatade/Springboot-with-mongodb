package com.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
