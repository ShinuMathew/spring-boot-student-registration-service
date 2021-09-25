package com.example.demo.request.mapper;

import java.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.repository.collection.Course;
import com.example.demo.request.CourseRequest;

/**
 * @implNote Map request to data
 * */

@Component
public class CourseRequestMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Course mapSaveCourseResponse(CourseRequest courseRequest) {
		Course course = modelMapper.map(courseRequest, Course.class);
		course.setCreatedDate(LocalDateTime.now());
		course.setModifiedDate(LocalDateTime.now());
		return course;
	}
}
