package com.example.main.dto;

import com.example.main.entity.Hiring;
import com.example.main.entity.HiringPartner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashtagsDto {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private HiringPartner hiringPartner;
    private Hiring hiring;
}
