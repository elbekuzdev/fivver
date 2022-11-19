package com.example.main.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String profession;
    private byte count;
    @ManyToOne
    private HiringPartner hiringPartner;
}
