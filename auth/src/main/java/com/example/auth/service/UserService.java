package com.example.auth.service;

import com.example.auth.dto.UsersDto;
import com.example.auth.entity.District;
import com.example.auth.entity.Links;
import com.example.auth.entity.Region;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.DistrictRepo;
import com.example.auth.repo.LinksRepository;
import com.example.auth.repo.RegionRepo;
import com.example.auth.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final RegionRepo regionRepo;
    private final DistrictRepo districtRepo;
    private final LinksRepository linksRepository;

    public ResponseDto register(UsersDto usersDto) {
        try {
            Users user = UsersMapper.toEntity(usersDto);
            if (!usersRepository.existsByEmail(user.getEmail())) {
                String phoneNumber = user.getPhoneNumber();
                if (!usersRepository.existsByPhoneNumber(phoneNumber)) {
                    if (user.getDistrict() != null && user.getRegion() != null) {
                        Optional<District> optionalDistrict = districtRepo.findById(user.getDistrict().getId());
                        if (optionalDistrict.isPresent()) {
                            District district = optionalDistrict.get();
                            Optional<Region> optionalRegion = regionRepo.findById(user.getRegion().getId());
                            if (optionalRegion.isPresent()) {
                                Region region = optionalRegion.get();
                                if (Objects.equals(district.getRegion().getId(), region.getId())) {
                                    try {
                                        Set<Links> links = null;
                                        if (user.getLinks() != null) {
                                            links = user.getLinks();
                                        } else {
                                            links = new HashSet<>();
                                        }
                                        user.setLinks(links);
                                        linksRepository.saveAll(links);
                                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                                        System.out.println(user.getLinks());
                                        Users save = usersRepository.save(user);
                                        return new ResponseDto(200, "ok", save);


                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return ResponseDto.getSuccess(205, "not saved");
                                    }

                                } else {
                                    return ResponseDto.getSuccess(205, "district not attributed to region");
                                }
                            } else {
                                return ResponseDto.getSuccess(205, "region not found");
                            }
                        } else {
                            return ResponseDto.getSuccess(205, "district not found");
                        }
                    } else {
                        return ResponseDto.getSuccess(205, "region or district is invalid");
                    }

                } else {
                    return ResponseDto.getSuccess(205, "phone number is already is eixsts");
                }
            } else {
                return ResponseDto.getSuccess(205, "email is already is exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.getSuccess(205, "not saved");
        }
    }

    public ResponseDto getAll() {
        List<Users> all = usersRepository.findAll();
        return ResponseDto.getSuccess(all);
    }


    public ResponseDto loginUser(String email, String password) {
        Optional<Users> users = usersRepository.findByEmail(email);
        if (users.isPresent() && passwordEncoder.matches(password, users.get().getPassword())) {
            return ResponseDto.getSuccess(users.get());
        }
        return ResponseDto.UserNotFound();
    }

    public ResponseDto deleteById(Integer id) {
        usersRepository.deleteById(id);
        return ResponseDto.getSuccess(200, "successfully deleted");
    }

    public ResponseDto update(UsersDto usersDto) {
        {
            System.out.println(usersDto.getLinks());
            Users user = UsersMapper.toEntity(usersDto);
            System.out.println(user.getLinks());
            if (user.getDistrict() != null && user.getRegion() != null) {
                Optional<District> optionalDistrict = districtRepo.findById(user.getDistrict().getId());
                if (optionalDistrict.isPresent()) {
                    District district = optionalDistrict.get();
                    Optional<Region> optionalRegion = regionRepo.findById(user.getRegion().getId());
                    if (optionalRegion.isPresent()) {
                        Region region = optionalRegion.get();
                        if (Objects.equals(district.getRegion().getId(), region.getId())) {
                            try {
                                Optional<Users> optionalUser = usersRepository.findById(usersDto.getId());
                                if (optionalUser.isPresent()) {
                                    Users users = optionalUser.get();
                                    Set<Links> links = null;
                                    if (user.getLinks() != null) {
                                        links = user.getLinks();
                                    } else {
                                        links = new HashSet<>();
                                    }
                                    if (users.getLinks() != null) {
                                        links.addAll(users.getLinks());
                                    }
                                    user.setLinks(links);

                                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                                    linksRepository.saveAll(links);
                                    Users save = user;
                                    try {
                                        save = usersRepository.save(user);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    return new ResponseDto(200, "ok", save);

                                } else {
                                    return ResponseDto.getSuccess(205, "user not found");
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                                return ResponseDto.getSuccess(205, "not saved");
                            }

                        } else {
                            return ResponseDto.getSuccess(205, "district not attributed to region");
                        }
                    } else {
                        return ResponseDto.getSuccess(205, "region not found");
                    }
                } else {
                    return ResponseDto.getSuccess(205, "district not found");
                }
            } else {
                return ResponseDto.getSuccess(205, "region or district is invalid");
            }

        }
    }
}
