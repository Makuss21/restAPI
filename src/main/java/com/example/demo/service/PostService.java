package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private static final int pageSize = 20;
    private final CommentsRepository cRepository;
    private final CommentsRepository commentsRepository;

    public List<Post> getPosts(int pageNumber, Sort.Direction sort) {
        return postRepository.findAllPosts(
                PageRequest.of(pageNumber,pageSize,
                        Sort.by(sort, "id")));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int pageNumber, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(
                PageRequest.of(pageNumber,pageSize,
                        Sort.by(sort, "id")));

        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .toList();

        List<Comment> commentList = commentsRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComments(extractComments(commentList, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> commentList, long id) {
        return commentList.stream()
                .filter(comment -> comment.getPostId() == id)
                .toList();
    }
}
