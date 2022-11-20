package com.example.auth.mapper;

import com.example.auth.dto.DistrickDto;
import com.example.auth.entity.District;

public class DistrictMapper {
    public static District toEntity(DistrickDto districkDto){
        return new District(districkDto.getId(), districkDto.getName(),districkDto.getRegion());
    }
    public static DistrickDto toDto(District district){
        return new DistrickDto(district.getId(),
                district.getName(),district.getRegion());
    }
}
