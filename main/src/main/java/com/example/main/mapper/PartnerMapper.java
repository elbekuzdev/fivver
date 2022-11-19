package com.example.main.mapper;

import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.PartnerDto;
import com.example.main.entity.HiringPartner;
import com.example.main.entity.Partner;

public class PartnerMapper {
    public static Partner toEntity(PartnerDto partnerDto) {
        return new Partner(partnerDto.getId(), partnerDto.getProfession(),
                partnerDto.getCount(), partnerDto.getHiringPartner(), partnerDto.isActive());
    }


    public static PartnerDto toDto(Partner partner) {
        return new PartnerDto(partner.getId(), partner.getProfession(),
                partner.getCount(), partner.getHiringPartner(), partner.isActive());
    }
}
