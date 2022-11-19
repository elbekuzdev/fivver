package com.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String profession;
    private byte count;
    @ManyToOne
    private HiringPartner hiringPartner;
    private boolean isActive = true;
}
