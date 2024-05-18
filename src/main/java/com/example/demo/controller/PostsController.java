package com.example.demo.controller;

import com.example.demo.controller.dto.PostDataTransferObject;
import com.example.demo.controller.dto.PostDtoMapper;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDataTransferObject> getPosts(@RequestParam(required = false) int page, Sort.Direction sort){
        int pageNumber = page >= 0 ? page : 0;
        return PostDtoMapper.mapToDtos(postService.getPosts(pageNumber,sort));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) int page, Sort.Direction sort){
        int pageNumber = page >= 0 ? page : 0;
        return postService.getPostsWithComments(pageNumber,sort);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.getSinglePost(id);
    }
}
