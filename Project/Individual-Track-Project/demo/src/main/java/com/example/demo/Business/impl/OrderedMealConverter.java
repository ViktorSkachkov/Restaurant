package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.OrderedMeal;
import com.example.demo.dto.OrderedMealDTO;

public class OrderedMealConverter {
    private OrderedMealConverter() {

    }

    public static OrderedMealDTO convertToDTO(OrderedMeal orderedMeal) {
        return OrderedMealDTO.builder()
                .id(Math.toIntExact(orderedMeal.getId()))
                .user(orderedMeal.getUserId())
                .meal(orderedMeal.getMealId())
                .build();
    }
}
