package com.example.demo.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty("course_id") private String courseId;	
	@JsonProperty("course_name") private String courseName;	
	@JsonProperty("course_type") private String courseType;
	@JsonProperty("course_start_date") private LocalDateTime startDate;
	@JsonProperty("course_end_date") private LocalDateTime endDate;
	@JsonProperty("course_status_notification") private String courseStatusNotification;
	@JsonProperty("created_date") private LocalDateTime createdDate;
	@JsonProperty("modified_date") private LocalDateTime modifiedDate;
	
}
