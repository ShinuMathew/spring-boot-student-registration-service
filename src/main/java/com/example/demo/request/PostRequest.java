package com.example.demo.request;

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
public class PostRequest {

	@NotBlank @Size(min = 5, max = 5)
	@Pattern(regexp = "[A-Z]{2}\\d{3}")
	private String id;
	@NotBlank private String title;
	private String description;
	private String content;
	@NotBlank private String status;	
	
}
