package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @Column
    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

    @OneToMany
    @JoinColumn(name = "clientId")
    private List<Orders> orders;
}
