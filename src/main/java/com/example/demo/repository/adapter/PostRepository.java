package com.example.demo.repository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.collection.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	
	
}
