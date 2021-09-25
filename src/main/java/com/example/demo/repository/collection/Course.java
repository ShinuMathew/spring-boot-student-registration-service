package com.example.demo.repository.collection;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.demo.enums.CourseType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Document(collection = "course")
public class Course {

	@Id
	@Field("course_id") public String courseId;
	@Field("course_name") public String courseName;
	@Field("course_type") public String courseType;
	@Field("course_start_date") public LocalDateTime startDate;
	@Field("course_end_date") public LocalDateTime endDate;
	@Field("created_date") private LocalDateTime createdDate;
	@Field("modified_date") private LocalDateTime modifiedDate;
}
