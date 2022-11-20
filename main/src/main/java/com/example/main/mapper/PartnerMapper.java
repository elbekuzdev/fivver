package com.example.main.mapper;

import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.PartnerDto;
import com.example.main.entity.HiringPartner;
import com.example.main.entity.Partner;

import java.util.HashSet;
import java.util.Set;

public class PartnerMapper {
    public static Partner toEntity(PartnerDto partnerDto) {
        return new Partner(partnerDto.getId(), partnerDto.getProfession(), partnerDto.getCount());
    }

    public static Set<Partner> toEntity(Set<PartnerDto> partnerDtos){
        HashSet<Partner> partners = new HashSet<>();
        for (PartnerDto dto:partnerDtos) {

            partners.add(toEntity(dto));
        }

        return partners;
    }


    public static PartnerDto toDto(Partner partner) {
        return new PartnerDto(partner.getId(), partner.getProfession(), partner.getCount());
    }

    public static Set<PartnerDto> toDto(Set<Partner> partnerDtos){
        HashSet<PartnerDto> dtos = new HashSet<>();
        for (Partner partner:partnerDtos) {

            dtos.add(toDto(partner));
        }

        return dtos;
    }


}
