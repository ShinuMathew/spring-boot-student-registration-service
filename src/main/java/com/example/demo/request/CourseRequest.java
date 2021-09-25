package com.example.demo.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class CourseRequest {

	@NotBlank @Size(min = 5, max = 5)
	@Pattern(regexp = "[A-Z]{2}\\d{3}")
	private String courseId;
	@NotBlank
	private String courseName;
	@NotBlank
	private String courseType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
