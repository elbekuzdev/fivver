package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import com.example.auth.model.ResMessage;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResMessage register(UsersDto usersDto);
    ResMessage getAll();
    ResMessage getUserById(Integer id);
}
