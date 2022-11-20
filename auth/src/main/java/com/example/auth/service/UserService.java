package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.model.ResMessage;
import com.example.auth.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UsersRepository usersRepository;
    public ResMessage register(UsersDto usersDto) {
        usersRepository.save(UsersMapper.toEntity(usersDto));
        return ResMessage.getSuccess(0,"200");
    }

    public ResMessage getAll() {
        List<Users> all = usersRepository.findAll();
        return ResMessage.getSuccess(all);
    }

    public ResMessage getUserById(Integer id) {
        Optional<Users> byId = usersRepository.findById(id);
        Users users = byId.get();
        return ResMessage.getSuccess(users);
    }


    public ResMessage loginUser(String email, String password) {
        Optional<Users> users = usersRepository.findByEmailAndPassword(email, password);
        if (users.isPresent()){
            return ResMessage.getSuccess(users.get());
        }return ResMessage.UserNotFound();
    }
    public ResMessage deleteById(Integer id){
        usersRepository.deleteById(id);
        return ResMessage.getSuccess(200,"succesfully deleted");
    }
}
