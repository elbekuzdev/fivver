package com.example.auth.mapper;

import com.example.auth.dto.RegionDto;
import com.example.auth.entity.Region;

public class RegionMapper {
    public static Region toEntity(RegionDto regionDto){
        return new Region(regionDto.getId(), regionDto.getName());
    }
    public static RegionDto toDto(Region region){
        return new RegionDto(region.getId(), region.getName());
    }
}
