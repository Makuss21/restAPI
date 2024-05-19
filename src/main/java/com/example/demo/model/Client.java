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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "clientId", updatable = false, insertable = false)
    private List<Orders> orders;
}
