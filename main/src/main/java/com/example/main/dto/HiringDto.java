package com.example.main.dto;

import com.example.main.entity.State;
import com.example.main.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

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
    @NotBlank(message = "Start price is mandatory")
    private Double StartPrice;
    private Double price;
    private Timestamp creationTime;
    private boolean isActive = true;
}
