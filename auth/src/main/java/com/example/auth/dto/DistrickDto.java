package com.example.auth.dto;

import com.example.auth.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrickDto {
    private Integer id;
    private String name;
    private Region region;
}
