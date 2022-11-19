package com.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hiring {
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
    @CreationTimestamp
    private Timestamp creationTime;
    private Boolean isActive = true;
}