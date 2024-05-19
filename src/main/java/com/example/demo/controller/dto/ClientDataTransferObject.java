package com.example.demo.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ClientDataTransferObject {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

}
