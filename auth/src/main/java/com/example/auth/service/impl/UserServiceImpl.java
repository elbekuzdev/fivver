package com.example.auth.service.impl;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.model.ResMessage;
import com.example.auth.repo.UsersRepository;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    @Override
    public ResMessage register(UsersDto usersDto) {
        Users users = UsersMapper.toEntity(usersDto);
        Users save = usersRepository.save(users);
        return ResMessage.getSuccess(0,"200");

    }

    @Override
    public ResMessage getAll() {
        return null;
    }

    @Override
    public ResMessage getUserById(Integer id) {
        return null;
    }
}
