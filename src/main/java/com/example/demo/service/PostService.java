package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.adapter.PostRepository;
import com.example.demo.response.PostResponse;
import com.example.demo.response.mapper.PostResponseMapper;

@Service
public class PostService {

	@Autowired
	private PostResponseMapper postMapper;
	@Autowired
	private PostRepository postRepository;
	
	public List<PostResponse> getAllPosts() {
		return postMapper.mapPostsToPostResponse(postRepository.findAll());
	}
}
