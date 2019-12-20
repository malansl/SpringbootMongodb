package com.malands.SpringbootMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.malands.SpringbootMongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
