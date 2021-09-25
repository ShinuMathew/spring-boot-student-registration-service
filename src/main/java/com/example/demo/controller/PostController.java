package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.PostResponse;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("")	
	public List<PostResponse> getAllPosts() {		
		return postService.getAllPosts();
	}
}
