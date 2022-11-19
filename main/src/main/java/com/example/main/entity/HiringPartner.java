package com.example.main.entity;

import javax.persistence.*;

@Entity
public class HiringPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String  description;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private Users user;
    private Double StartPrice;
    private Double price;


}
