package com.example.demo.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class CourseResponse {

	private String courseId;	
	private String courseName;	
	private String courseType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String courseStatusNotification;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
}
