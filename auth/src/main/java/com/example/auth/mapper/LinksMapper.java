package com.example.auth.mapper;

import com.example.auth.dto.LinksDto;
import com.example.auth.entity.Links;

import java.util.HashSet;
import java.util.Set;

public class LinksMapper {
    public static Links toEntity(LinksDto linksdto) {
        if (linksdto != null) return new Links(linksdto.getId(), linksdto.getName(), linksdto.getUrl());
        return new Links();
    }

    public static Set<Links> toEntity(Set<LinksDto> linksDtos) {
        HashSet<Links> links = new HashSet<>();
        if (linksDtos != null) for (LinksDto linksDto : linksDtos)
            links.add(toEntity(linksDto));
        return links;
    }

    public static LinksDto toDto(Links links) {
        if (links != null) return new LinksDto(links.getId(), links.getName(), links.getUrl());
        return new LinksDto();
    }

    public static Set<LinksDto> toDto(Set<Links> links) {
        HashSet<LinksDto> linksDtos = new HashSet<>();
        if (links != null) for (Links link : links)
            linksDtos.add(toDto(link));
        return linksDtos;
    }


}
