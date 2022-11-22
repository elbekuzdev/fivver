package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.District;
import com.example.auth.entity.Region;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.DistrictRepo;
import com.example.auth.repo.RegionRepo;
import com.example.auth.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UsersRepo usersRepo;
    private final RegionRepo regionRepo;
    private final DistrictRepo districtRepo;
    public ResponseDto register(UsersDto usersDto) {
        try {
            Users user = UsersMapper.toEntity(usersDto);
            if (!usersRepo.existsByEmail(user.getEmail())){
                String phoneNumber = user.getPhoneNumber();
                if (!usersRepo.existsByPhoneNumber(phoneNumber)){


                    if (user.getDistrict() != null && user.getRegion() != null){
                        Optional<District> optionalDistrict = districtRepo.findById(user.getDistrict().getId());
                        if (optionalDistrict.isPresent()){
                            District district = optionalDistrict.get();
                            Optional<Region> optionalRegion = regionRepo.findById(user.getRegion().getId());
                            if (optionalRegion.isPresent()){
                                Region region = optionalRegion.get();
                                if (Objects.equals(district.getRegion().getId(), region.getId())){
                                    try {
                                        Users save = usersRepo.save(user);
                                        return new ResponseDto(200, "saved", save);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                        return ResponseDto.getSuccess(205, "not saved");

                                    }

                                }else {
                                    return ResponseDto.getSuccess(205, "district not attributed to region");
                                }
                            }else{
                                return ResponseDto.getSuccess(205, "region not found");
                            }
                        }else{
                            return ResponseDto.getSuccess(205,"district not found");
                        }
                    }else{
                        return ResponseDto.getSuccess(205, "region or district is invalid");
                    }

                }else{
                    return ResponseDto.getSuccess(205, "phone number is already is eixsts");
                }
            }else{
                return ResponseDto.getSuccess(205, "email is already is exists");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.getSuccess(205, "not saved");
        }
    }

    public ResponseDto getAll() {
        List<Users> all = usersRepo.findAllByIsactive(true);
        return ResponseDto.getSuccess(all);
    }

    public ResponseDto getUserById(Integer id) {
        Optional<Users> byId = usersRepo.findById(id);
        Users users = byId.get();
        return ResponseDto.getSuccess(users);
    }


    public ResponseDto loginUser(String email, String password) {
        Optional<Users> users = usersRepo.findByEmail(email);
        if (users.isPresent() && passwordEncoder.matches(password,users.get().getPassword())){
            return ResponseDto.getSuccess(users.get());
        }return ResponseDto.UserNotFound();
    }

    public ResponseDto deleteById(Integer id){
        Optional<Users> optionalUsers = usersRepo.findById(id);
        if (optionalUsers.isPresent()){
            Users users = optionalUsers.get();
            users.setIsactive(false);
            usersRepo.save(users);
            return ResponseDto.getSuccess(200,"User deleted");
        }
        return ResponseDto.UserNotFound();
    }
}
