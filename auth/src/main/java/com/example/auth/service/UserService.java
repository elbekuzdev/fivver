package com.example.auth.service;

import com.example.auth.dto.ResponseDto;
import com.example.auth.dto.UsersDto;
import com.example.auth.entity.District;
import com.example.auth.entity.Links;
import com.example.auth.entity.Region;
import com.example.auth.entity.Users;
import com.example.auth.mapper.UsersMapper;
import com.example.auth.repo.DistrictRepo;
import com.example.auth.repo.LinksRepo;
import com.example.auth.repo.RegionRepo;
import com.example.auth.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    private final UsersRepo usersRepo;
    private final RegionRepo regionRepo;
    private final DistrictRepo districtRepo;
    private final LinksRepo linksRepo;

    public ResponseDto register(UsersDto usersDto) {
        try {
            Users user = UsersMapper.toEntity(usersDto);
            if (!usersRepo.existsByEmail(user.getEmail())){
                String phoneNumber = user.getPhoneNumber();
                if (!usersRepo.existsByPhoneNumber(phoneNumber)){
                    if (user.getDistrict() != null && user.getRegion() != null){
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
                                        linksRepo.saveAll(links);
                                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                                        System.out.println(user.getLinks());
                                        Users save = usersRepo.save(user);
                                        return new ResponseDto(200, "ok", save);
                                    }catch (Exception e){
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
        List<Users> all = usersRepo.findAllByIsactive(true);
        return ResponseDto.getSuccess(all);
    }


    public ResponseDto getUserById(Integer id) {
        Optional<Users> byId = usersRepo.findById(id);
        Users users = byId.get();
        return ResponseDto.getSuccess(users);
    }


    public ResponseDto loginUser(String email, String password) {
        Optional<Users> users = usersRepo.findByEmailAndIsactive(email,true);
        if (users.isPresent() && passwordEncoder.matches(password,users.get().getPassword())){
            return ResponseDto.getSuccess(users.get());
        }
        return ResponseDto.UserNotFound();
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

    public ResponseDto update(UsersDto usersDto) {


        Users user = UsersMapper.toEntity(usersDto);
        Optional<Users> users = usersRepository.findById(user.getId());
        if (users.isPresent()) {
            Users users1 = users.get();
            if (user.getFirstname() == null) {
                user.setFirstname(users1.getFirstname());
            }
            if (user.getLastname() == null) {
                user.setFirstname(users1.getFirstname());
            }
            if (user.getProfession() == null) {
                user.setProfession(users1.getProfession());
            }
            if (user.getSummary() == null) {
                user.setSummary(users1.getSummary());
            }
            if (user.getPassword() == null) {
                user.setPassword(users1.getPassword());
            }
            if (user.getRegion() == null) {
                user.setRegion(users1.getRegion());
            } else { // agar region almashtirsa aniq tuman almashtirshi kere, ushanga elseda tumanniyam tekshiraman
                if (user.getDistrict() != null) {
                    Optional<District> optionalDistrict = districtRepo.findById(user.getDistrict().getId());
                    if (optionalDistrict.isPresent()) {
                        District district = optionalDistrict.get();
                        Optional<Region> optionalRegion = regionRepo.findById(user.getRegion().getId());
                        if (optionalRegion.isPresent()) {
                            Region region = optionalRegion.get();
                            if (Objects.equals(district.getRegion().getId(), region.getId())) {
                                user.setDistrict(district);
                                user.setRegion(region);
                            } else {
                                return ResponseDto.getSuccess(205, "District not found");
                            }
                        } else {
                            return ResponseDto.getSuccess(205, "Region not found");
                        }
                    }
                }
                return ResponseDto.getSuccess(205, "Choose the District!");


            }
      

            if (user.getDistrict() == null) {
                user.setDistrict(users1.getDistrict());
            } else {

                //* maqsad agar district ozgarmoqchi bosa, tekshiradi,
                // viloyatti ichida bormi bunaqa district, bomasa yo didi bosa set qiladi
                Optional<District> byId = districtRepo.findById(user.getDistrict().getId());
                if (byId.isPresent()) {
                    District district = byId.get();
                    Optional<Region> regionOptional = regionRepo.findById(user.getRegion().getId());
                    if (regionOptional.isPresent()) {
                        Region region = regionOptional.get();

                        if (Objects.equals(district.getRegion().getId(), region.getId())) {
                            user.setDistrict(district);
                        } else {
                            return ResponseDto.getSuccess(205, "District not found");
                        }
                    } else {
                        return ResponseDto.getSuccess(205, "Region not found");
                    }
                } else {
                    return ResponseDto.getSuccess(205, "District is invalid");
                }

                return ResponseDto.getSuccess(205, "User not found");

            }

            if (user.getPhoneNumber() == null) {
                user.setPhoneNumber(users1.getPhoneNumber());
            }

            if(user.getEmail()== null){
                user.setEmail(users1.getEmail());
         }
            if(user.getLinks()==null){
                user.setLinks(users1.getLinks());
            }

            if(user.getProfilePicture()==null){
                user.setProfilePicture(users1.getProfilePicture());
            }
            usersRepository.save(user);
            return ResponseDto.getSuccess(200, "updated");
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepo.findByEmailAndIsactive(email,true).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}



}

