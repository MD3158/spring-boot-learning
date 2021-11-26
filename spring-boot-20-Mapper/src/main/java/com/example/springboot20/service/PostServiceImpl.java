package com.example.springboot20.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

  @Autowired private PostRepository postRepository;

  @Override
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @Override
  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  @Override
  public void deletePost(long id) {
    postRepository.deleteById(id);
  }

  @Override
  public Post getPostById(long id) {
    Optional<Post> result = postRepository.findById(id);
    return result.get();
  }
//  @Override
//  public Post updatePost(long id, Post postRequest){
//    Optional<Post> post = postRepository.findById(id);
//    post.setTitle(postRequest.getTitle());
//    post.setDescription(postRequest.getDescription());
//    post.setContent(postRequest.getContent());
//    return postRepository.save(post);
//  }
}