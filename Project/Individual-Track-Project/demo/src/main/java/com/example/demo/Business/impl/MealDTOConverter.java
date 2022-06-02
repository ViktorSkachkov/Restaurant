package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;

final class MealDTOConverter {

    /*private MealDTOConverter(GetCategoriesUseCase getCategoriesUseCase) {

    }*/
    public static MealDTO convertToDTO(Meal meal) {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(meal.getCategory().getId()))
                .name(meal.getCategory().getName())
                .image(meal.getCategory().getImage())
                .build();
        return MealDTO.builder()
                .id(Math.toIntExact(meal.getId()))
                .category(categoryDTO)
                .image(meal.getImage())
                .name(meal.getName())
                .description(meal.getDescription())
                .weight(meal.getWeight())
                .price(meal.getPrice())
                .build();
    }
}
