package com.example.demo.controller.dto;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDataTransferObject {
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;

}
