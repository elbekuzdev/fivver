package com.example.main.mapper;

import com.example.main.dto.HiringPartnerDto;
import com.example.main.entity.HiringPartner;

public class HiringPartnerMapper {

    public static HiringPartner toEntity(HiringPartnerDto hiringPartnerDto){
        return new HiringPartner(hiringPartnerDto.getId(), hiringPartnerDto.getTitle(),
                hiringPartnerDto.getDescription(), hiringPartnerDto.getState(), hiringPartnerDto.getUser(),
                hiringPartnerDto.getStartPrice(), hiringPartnerDto.getPrice(), PartnerMapper.toEntity(hiringPartnerDto.getPartners()), HashtagsMapper.toEntity(hiringPartnerDto.getTags()), hiringPartnerDto.getCreationTime(), hiringPartnerDto.isActive());
    }
    public static HiringPartnerDto toDto(HiringPartner hiringPartner){
        return new HiringPartnerDto(hiringPartner.getId(), hiringPartner.getTitle(), hiringPartner.getDescription(),
                hiringPartner.getState(), hiringPartner.getUser(),
                hiringPartner.getPrice(), hiringPartner.getPrice(), PartnerMapper.toDto(hiringPartner.getPartners()),HashtagsMapper.toDto(hiringPartner.getTags()), hiringPartner.getCreationTime(), hiringPartner.getIsActive());
    }

}
