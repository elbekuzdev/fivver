package com.example.auth.dto;

import com.example.auth.annotation.ValidatePhoneNumber;
import com.example.auth.entity.District;
import com.example.auth.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Integer Id;
    @NotBlank(message = "FirstName is mandatory")
    private String firstname;
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;
    @NotBlank(message = "Profession is mandatory")
    private String profession;
    private String summary;
    @Length(min = 8)
    private String password;
    private Region region;
    private District district;
    @ValidatePhoneNumber( message = "PhoneNumber is not valid")
    private String phoneNumber;
    @Email(message = "Email is not valid")
    private String email;
    private Set<LinksDto> links;
    private ImageDto profilePicture;

}
