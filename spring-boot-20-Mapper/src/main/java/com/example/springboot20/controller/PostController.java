package com.example.springboot20.controller;

import com.example.springboot20.dto.PostDto;
import com.example.springboot20.model.Post;
import com.example.springboot20.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private ModelMapper modelMapper;
    private PostService postService;

    public PostController(PostService postService) {
        super();
        this.postService = postService;
    }
    //Get
    @GetMapping
    public List<PostDto> getAllPosts() {

        return postService.getAllPost().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }
    //Post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        // convert DTO to entity
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.createPost(postRequest);

        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
    }
    //Delete
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        Post post = postService.getPostById(id);

        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);
    }
  // Update
  // change the request for DTO
  // change the response for DTO
      @PutMapping("/{id}")
  	public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto)
   {

  		// convert DTO to Entity
  		Post postRequest = modelMapper.map(postDto, Post.class);

  		Post post = postService.updatePost(id, postRequest);

  		// entity to DTO
  		PostDto postResponse = modelMapper.map(post, PostDto.class);

  		return ResponseEntity.ok().body(postResponse);
  	}
}
