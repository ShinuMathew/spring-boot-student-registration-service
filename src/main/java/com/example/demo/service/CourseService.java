package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.Status;
import com.example.demo.repository.adapter.CourseRepository;
import com.example.demo.repository.collection.Course;
import com.example.demo.request.CourseRequest;
import com.example.demo.request.mapper.CourseRequestMapper;
import com.example.demo.response.CourseResponse;
import com.example.demo.response.UpdateResponse;
import com.example.demo.response.mapper.CourseResponseMapper;

@Service
public class CourseService {

	@Autowired
	private CourseResponseMapper courseResponseMapper;

	@Autowired
	private CourseRequestMapper courseRequestMapper;

	@Autowired
	private CourseRepository courseRepository;

	public List<CourseResponse> getAllCourse() {
		return courseResponseMapper.mapCoursesToCourseResponse(courseRepository.findAll());
	}

	public UpdateResponse saveCourse(CourseRequest courseRequest) {
		try {
			Course course = courseRequestMapper.mapSaveCourseResponse(courseRequest);
			courseRepository.save(course);
			return UpdateResponse.builder()
					.status(Status.SUCCESS.getValue())
					.message("Course Updated Successfully!")
					.build();
		} catch (Exception e) {
			return UpdateResponse.builder()
					.status(Status.FAILED.getValue())
					.message("Course Updated Failed. Please try again!")
					.build();
		}
	}

}
