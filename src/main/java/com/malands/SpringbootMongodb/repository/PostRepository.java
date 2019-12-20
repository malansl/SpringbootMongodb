package com.malands.SpringbootMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.malands.SpringbootMongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}
