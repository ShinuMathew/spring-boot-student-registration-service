package com.example.demo.repository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.repository.collection.Course;

public interface CourseRepository extends MongoRepository<Course, String> {

	
	
}
