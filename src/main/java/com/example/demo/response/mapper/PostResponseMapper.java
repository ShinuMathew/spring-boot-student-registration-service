package com.example.demo.response.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.collection.Post;
import com.example.demo.response.PostResponse;

/**
 * @implNote Map data to response
 * */

@Component
public class PostResponseMapper {

	@Autowired
	private ModelMapper modelMapper;

	public List<PostResponse> mapPostsToPostResponse(List<Post> posts) {
		return posts.stream().map(post -> {
			PostResponse postResponse = modelMapper.map(post, PostResponse.class);
			postResponse.setStatus(post.getStatus());
			return postResponse;
		}).collect(Collectors.toList());
	}

}