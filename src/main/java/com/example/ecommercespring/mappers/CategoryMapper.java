package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category entity){
        return CategoryDTO.builder()
                .name(entity.getName())
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

}
