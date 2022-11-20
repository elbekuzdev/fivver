package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UsersRepository usersRepository;
    public ResponseDto register(UsersDto usersDto) {
        try {
            usersRepository.save(UsersMapper.toEntity(usersDto));
            return ResponseDto.getSuccess(200,"saved");
        }catch (Exception e){
            return ResponseDto.getSuccess(200,"not saved");
        }

    }

    public ResponseDto getAll() {
        List<Users> all = usersRepository.findAll();
        return ResponseDto.getSuccess(all);
    }

    public ResponseDto getUserById(Integer id) {
        Optional<Users> byId = usersRepository.findById(id);
        Users users = byId.get();
        return ResponseDto.getSuccess(users);
    }


    public ResponseDto loginUser(String email, String password) {
        Optional<Users> users = usersRepository.findByEmailAndPassword(email, password);
        if (users.isPresent()){
            return ResponseDto.getSuccess(users.get());
        }return ResponseDto.UserNotFound();
    }
    public ResponseDto deleteById(Integer id){
        usersRepository.deleteById(id);
        return ResponseDto.getSuccess(200,"succesfully deleted");
    }
}
