package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPost(){
        return postService.getPosts();
    }
    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable("id") @Parameter(name = "id") Long id){
        return postService.getSinglePost(id);
    }
}
