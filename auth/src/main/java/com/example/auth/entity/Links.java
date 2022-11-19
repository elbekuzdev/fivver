package com.example.auth.entity;

import javax.persistence.*;

@Entity
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    @ManyToOne
    private Users user;
}
