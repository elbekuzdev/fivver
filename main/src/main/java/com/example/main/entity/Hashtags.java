package com.example.main.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Hashtags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private HiringPartner hiringPartner;
    @ManyToOne
    private Hiring hiring;
}
