package com.auth.using.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.auth.using.nosql.entity.User;

public interface UserRepo extends MongoRepository<User, Integer>,CrudRepository<User, Integer> {

}
