package com.example.demo.repository.collection;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Document(collection = "posts")
public class Post {

	@Id
	@Field("id") private String id;
	private String title;
	private String description;
	private String content;
	private String status;
	@Field("created_date") private LocalDateTime createdDate;
	@Field("modified_date") private LocalDateTime modifiedDate;
	
}
