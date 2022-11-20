package com.example.auth.controller;

import com.example.auth.dto.ResponseDto;
import com.example.auth.service.DistrictService;
import com.example.auth.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;
    private final DistrictService districtService;

    @GetMapping("/regions")
    public ResponseEntity<ResponseDto> getRegions(){
        return regionService.getRegions();
    }

    @GetMapping("/districts")
    public ResponseEntity<ResponseDto> getDistrict(){
        return districtService.getDistrict();
    }

    @GetMapping("/districtsById/{id}")
    public ResponseEntity<ResponseDto> getDistrictByRegionId(@PathVariable int id){
        return districtService.getDistrictByRegionId(id);
    }
}
