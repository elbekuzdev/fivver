package com.example.main.dto;


import com.example.main.entity.State;
import com.example.main.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HiringPartnerDto {
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String  description;
    private State state;
    private Users user;
    @NotNull
    private Double StartPrice;
    private Double price;
    private Timestamp creationTime;
    private boolean isActive = true;
}
