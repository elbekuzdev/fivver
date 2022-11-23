package com.example.auth.mapper;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import org.springframework.stereotype.Component;

public class UsersMapper {
    public static Users toEntity(UsersDto usersDto) {
        return new Users(
                usersDto.getId(),
                usersDto.getFirstname(),
                usersDto.getLastname(),
                usersDto.getProfession(),
                usersDto.getSummary(),
                usersDto.getPassword(),
                usersDto.getRegion(),
                usersDto.getDistrict(),
                usersDto.getPhoneNumber(),
                usersDto.getEmail(),
                usersDto.getProfilePicture());
    }

    public static UsersDto toDto(Users users) {
        return new UsersDto(
                users.getId(),
                users.getFirstname(),
                users.getLastname(),
                users.getProfession(),
                users.getSummary(),
                users.getPassword(),
                users.getRegion(),
                users.getDistrict(),
                users.getPhoneNumber(),
                users.getEmail(),
                users.getProfilePicture());
    }
}
