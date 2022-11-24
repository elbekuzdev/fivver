package com.example.auth.mapper;

import com.example.auth.dto.ImageDto;
import com.example.auth.entity.Image;

public class ImageMapper {

    public static Image toEntity(ImageDto imageDto) {
        if (imageDto != null)
            return new Image(imageDto.getId(), imageDto.getName(), imageDto.getType(), imageDto.getImageData());
        return new Image();
    }

    public static ImageDto toDto(Image image) {
        if (image != null) return new ImageDto(image.getId(), image.getName(), image.getType(), image.getImageData());
        return new ImageDto();
    }
}
