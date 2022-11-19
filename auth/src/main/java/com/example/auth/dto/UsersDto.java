package com.example.auth.dto;

import com.example.auth.annotation.ValidatePhoneNumber;
import com.example.auth.entity.District;
import com.example.auth.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Integer Id;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    @NotBlank(message = "Profession is mandatory")
    private String profession;
    private String summary;
    private Region region;
    private District district;
    @ValidatePhoneNumber
    private String phoneNumber;
    @Email(message = "Email is not valid")
    private String email;
    private CommonsMultipartFile profilePicture;

}
