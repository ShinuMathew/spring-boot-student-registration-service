package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.Status;
import com.example.demo.exception.CrudException;
import com.example.demo.repository.adapter.CourseRepository;
import com.example.demo.repository.collection.Course;
import com.example.demo.request.CourseRequest;
import com.example.demo.request.CourseUpdateRequest;
import com.example.demo.request.mapper.CourseRequestMapper;
import com.example.demo.response.CourseResponse;
import com.example.demo.response.UpdateResponse;
import com.example.demo.response.mapper.CourseResponseMapper;
import static java.lang.String.*;

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
					.message("Course Added Successfully!")
					.build();
		} catch (Exception e) {
			return UpdateResponse.builder()
					.status(Status.FAILED.getValue())
					.message("Course Addition Failed. Please try again!")
					.build();
		}
	}
	
	public UpdateResponse updateCourse(String id, CourseUpdateRequest courseUpdateRequest) throws CrudException {
		Optional<Course> existingCourse = courseRepository.findById(id);
		if(existingCourse.isEmpty())
			throw new CrudException(String.format("Course with id : %s not found", id), 409);
		Course course = courseRequestMapper.mapSaveCourseResponse(courseUpdateRequest);
		course.setCourseId(id);
		course.setCreatedDate(existingCourse.get().getCreatedDate());
		course.setModifiedDate(LocalDateTime.now());
		
		courseRepository.save(course);
		return UpdateResponse.builder()
				.status(Status.SUCCESS.getValue())
				.message("Course Updated Successfully!")
				.build();
	}

	public UpdateResponse deleteCourse(String id) {
		try {
			Optional<Course> existingCourse = courseRepository.findById(id);
			if(existingCourse.isEmpty())
				throw new CrudException(String.format("Course with id : %s not found", id), 409);
			courseRepository.deleteById(id);
			return UpdateResponse.builder()
					.status(Status.SUCCESS.getValue())
					.message("Course Deleted Successfully!")
					.build();
		} catch (Exception e) {
			return UpdateResponse.builder()
					.status(Status.FAILED.getValue())
					.message("Course Deleted Failed. Please try again!")
					.build();
		}
	}

	public CourseResponse getCourseById(String id) throws CrudException {
		Optional<Course> existingCourse = courseRepository.findById(id);
		if(existingCourse.isEmpty())
			throw new CrudException(format("Course with id : %s not found", id), 404);
		return courseResponseMapper.mapCourseToCourseResponse(existingCourse.get());
	}

}
