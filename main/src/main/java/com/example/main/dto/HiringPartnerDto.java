package com.example.main.dto;


import com.example.main.entity.State;
import com.example.main.entity.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HiringPartnerDto {
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String  description;
    private State state = State.WAITING;
    private Users user;
    @NotNull
    private Double startPrice = 0.0;
    private Double price;
    private Set<PartnerDto> partners;
    private Set<HashTagDto> tags;
    private Timestamp creationTime;
    private boolean isActive = true;
}
