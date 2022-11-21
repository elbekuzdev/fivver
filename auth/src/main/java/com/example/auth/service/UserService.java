package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.DistrictRepo;
import com.example.auth.repo.RegionRepo;
import com.example.auth.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final RegionRepo regionRepo;
    private final DistrictRepo districtRepo;
    public ResponseDto register(UsersDto usersDto) {
        try {
            usersDto.setPassword(passwordEncoder.encode(usersDto.getPassword()));
            Users users = usersRepository.save(UsersMapper.toEntity(usersDto));
        if (users != null){
            if (users.getPassword().length()>=6){

                boolean region = regionRepo.findRegionByIdAndName(users.getRegion().getId(), users.getRegion().getName());
                boolean district = districtRepo.findByIdAndName(users.getDistrict().getId(), users.getDistrict().getName());

                if (region && district){
                    Users save = usersRepository.save(users);
                    return ResponseDto.getSuccess(200,"User is succesfully saved");
                }else {
                    return ResponseDto.getSuccess(555,"region or district is invalid");
                }
            }else {
                return ResponseDto.getSuccess(555,"username or password is invalid");
            }
        }else {
            return ResponseDto.getSuccess(555,"User is invalid");
        }
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
        Optional<Users> users = usersRepository.findByEmail(email);
        if (users.isPresent() && passwordEncoder.matches(password,users.get().getPassword())){
            return ResponseDto.getSuccess(users.get());
        }return ResponseDto.UserNotFound();
    }
    public ResponseDto deleteById(Integer id){
        usersRepository.deleteById(id);
        return ResponseDto.getSuccess(200,"succesfully deleted");
    }
}
