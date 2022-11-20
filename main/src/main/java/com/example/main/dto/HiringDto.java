package com.example.main.dto;

import com.example.main.entity.Hashtag;
import com.example.main.entity.State;
import com.example.main.entity.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiringDto {
    private Integer id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Description is mandatory")
    private String  description;
    private State state = State.WAITING;
    private Users user;
    @NotNull(message = "Start price is mandatory")
    private Double StartPrice;
    private Double price;
    private Set<HashTagDto> tags;
    private Timestamp creationTime;
    private boolean isActive = true;
}
