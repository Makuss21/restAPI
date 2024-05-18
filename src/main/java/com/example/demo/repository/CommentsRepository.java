package com.example.demo.repository;


import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {


   List<Comment> findAllByPostIdIn(List<Long> ids);
}