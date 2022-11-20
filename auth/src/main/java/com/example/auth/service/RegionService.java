package com.example.auth.service;

import com.example.auth.dto.ResponseDto;
import com.example.auth.repo.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepo regionRepository;

    public ResponseEntity<ResponseDto> getRegions(){
        return ResponseEntity.ok(new ResponseDto(200, "ok", regionRepository.findAll()));
    }

}
