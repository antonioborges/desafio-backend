package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.Post;

public interface PostService {
  
  List<Post> findAll();
  
  Post findById(Long id);

  Post save(Post post);
}
