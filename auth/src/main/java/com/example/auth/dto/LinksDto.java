package com.example.auth.dto;

import com.example.auth.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinksDto {
    private Integer id;
    private String name;
    private String url;
    private Users users;
}
