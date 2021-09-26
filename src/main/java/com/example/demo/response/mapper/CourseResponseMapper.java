package com.example.demo.response.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.enums.CourseNotification;
import com.example.demo.repository.collection.Course;
import com.example.demo.response.CourseResponse;
import com.example.demo.response.UpdateResponse;

/**
 * @implNote Map data to response
 * */

@Component
public class CourseResponseMapper {

	@Autowired
	private ModelMapper modelMapper;

	public List<CourseResponse> mapCoursesToCourseResponse(List<Course> courses) {
		return courses.stream().map(course -> {
			CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
			if (LocalDateTime.now().isBefore(course.getStartDate()))
				courseResponse.setCourseStatusNotification(CourseNotification.YETTOSTART.getValue());
			else if (LocalDateTime.now().isAfter(course.getStartDate())
					&& LocalDateTime.now().isBefore(course.getEndDate()))
				courseResponse.setCourseStatusNotification(CourseNotification.INPROGRESS.getValue());
			else if (LocalDateTime.now().isAfter(course.getEndDate()))
				courseResponse.setCourseStatusNotification(CourseNotification.FINISHED.getValue());

			return courseResponse;
		}).collect(Collectors.toList());
	}
	
	public CourseResponse mapCourseToCourseResponse(Course course) {
		return modelMapper.map(course, CourseResponse.class);
	}

}
