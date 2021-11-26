package com.example.springboot20.service;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();
    Post createPost(Post post);
    void deletePost(long id);
    Post getPostById(long id);
//    Post updatePost(long id, Post post);
}
