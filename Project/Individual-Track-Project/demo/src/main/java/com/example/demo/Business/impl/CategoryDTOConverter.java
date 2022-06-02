package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Category;
import com.example.demo.dto.CategoryDTO;

public class CategoryDTOConverter {
    private CategoryDTOConverter() {

    }
    public static CategoryDTO convertToDTO(Category category) {
        return CategoryDTO.builder()
                .id(Math.toIntExact(category.getId()))
                .name(category.getName())
                .image(category.getImage())
                .build();
    }
}
