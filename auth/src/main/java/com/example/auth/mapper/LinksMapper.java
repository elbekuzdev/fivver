package com.example.auth.mapper;

import com.example.auth.dto.LinksDto;
import com.example.auth.entity.Links;

public class LinksMapper {
    public static Links toEntity(LinksDto linksdto){
        return new Links(linksdto.getId(),linksdto.getName(),linksdto.getUrl(),
                linksdto.getUsers());
    }
    public static LinksDto toDto(Links links){
        return new LinksDto(links.getId(),links.getName(),
                links.getUrl(),links.getUser());
    }
}
