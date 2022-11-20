package com.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Partner hashtag = (Partner) o;
        return Objects.equals(profession.toLowerCase(), (hashtag).profession.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(profession.toLowerCase());
    }
   
}
