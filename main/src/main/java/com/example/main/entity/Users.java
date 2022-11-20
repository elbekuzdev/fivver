package com.example.main.entity;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String firstname;
    private String lastname;
    private String profession;
    private String summary;
    @ManyToOne
    private Region region;
    @ManyToOne
    private District district;
    private String phoneNumber;
    private String email;
//    private CommonsMultipartFile profilePicture;
}
