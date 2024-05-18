package com.example.demo.controller;

import com.example.demo.controller.dto.PostDataTransferObject;
import com.example.demo.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDtoMapper {

    private PostDtoMapper() {

    }

    public static List<PostDataTransferObject> mapToDtos(List<Post> posts) {
        return posts.stream()
                .map(post -> mapToPostDto(post))
                .collect(Collectors.toList());
    }


    public static PostDataTransferObject mapToPostDto(Post post) {
        return PostDataTransferObject.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();
    }

}
