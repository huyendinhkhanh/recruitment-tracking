package com.cmc.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cmc.recruitment.model.Post;
import com.cmc.recruitment.service.post.PostService;

@RestController
public class PostRestController {

	@Autowired
	PostService postService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getAllPosts() {
		return postService.getAllPosts().isEmpty() ? new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Post>>(postService.getAllPosts(), HttpStatus.OK);
	}
}
