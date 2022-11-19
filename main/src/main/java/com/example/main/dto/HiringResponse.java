package com.example.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiringResponse {
    private int id;
    private String title;
    private String description;
    private String state;
    private Date creationTime;
}
