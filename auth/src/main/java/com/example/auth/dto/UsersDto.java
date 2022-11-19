package com.example.auth.dto;

import com.example.auth.entity.District;
import com.example.auth.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Integer Id;
    private String firstname;
    private String lastname;
    private String profession;
    private String summary;
    private Region region;
    private District district;
    private String phoneNumber;
    private String email;
    private CommonsMultipartFile profilePicture;

}
