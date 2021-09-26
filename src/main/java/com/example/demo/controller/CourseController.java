package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CrudException;
import com.example.demo.request.CourseRequest;
import com.example.demo.request.CourseUpdateRequest;
import com.example.demo.response.CourseResponse;
import com.example.demo.response.UpdateResponse;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public List<CourseResponse> getAllCourses() {
		return courseService.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public CourseResponse getCourseById(@PathVariable String id) throws CrudException {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("")
	public UpdateResponse saveCourse(@Valid @RequestBody CourseRequest courseRequest) {
		return courseService.saveCourse(courseRequest);
	}
	
	@PutMapping("/{id}")
	public UpdateResponse updateCourse(@PathVariable String id, @Valid @RequestBody CourseUpdateRequest courseUpdateRequest) throws CrudException {
		return courseService.updateCourse(id, courseUpdateRequest);
	}
	
	@DeleteMapping("/{id}")
	public UpdateResponse deleteCourse(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}
	
}
