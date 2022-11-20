package com.example.auth.service;

import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.DistrictRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepo districtRepo;

    public ResponseEntity<ResponseDto> getDistrict(){
        return ResponseEntity.ok(new ResponseDto(200, "ok", districtRepo.findAll()));
    }

    public ResponseEntity<ResponseDto> getDistrictByRegionId(int regionId){
        return ResponseEntity.ok(new ResponseDto(200, "ok", districtRepo.findByRegionId(regionId)));
    }
}
