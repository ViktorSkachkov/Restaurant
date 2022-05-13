package com.example.demo.Business.impl;

import com.example.demo.Business.GetCategoriesUseCase;
import com.example.demo.Normal.Meal;
import com.example.demo.dto.MealDTO;

final class MealDTOConverter {

    /*private MealDTOConverter(GetCategoriesUseCase getCategoriesUseCase) {

    }*/
    public static MealDTO convertToDTO(Meal meal) {
        return MealDTO.builder()
                .id(meal.getId())
                .category(meal.getCategory())
                .image(meal.getImage())
                .name(meal.getName())
                .description(meal.getDescription())
                .weight(meal.getWeight())
                .price(meal.getPrice())
                .build();
    }
}
