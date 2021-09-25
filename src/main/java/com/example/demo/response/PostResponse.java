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
public class PostResponse {
	
	private String id;
	private String title;
	private String description;
	private String content;
	private String status;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
}
