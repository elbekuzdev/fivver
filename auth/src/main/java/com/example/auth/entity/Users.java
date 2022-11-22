package com.example.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String profession;
    private String summary;
    private String password;
    @ManyToOne
    private Region region;
    @ManyToOne
    private District district;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private Boolean isactive = true;
    private CommonsMultipartFile profilePicture;
}
