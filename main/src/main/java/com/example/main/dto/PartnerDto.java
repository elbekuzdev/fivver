package com.example.main.dto;

import com.example.main.entity.HiringPartner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {
    private Integer id;
    @NotNull
    private String profession;
    private byte count;
    private HiringPartner hiringPartner;
    private boolean isActive = true;
}
