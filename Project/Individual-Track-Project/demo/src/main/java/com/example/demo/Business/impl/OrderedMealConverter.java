package com.example.demo.Business.impl;

import com.example.demo.Normal.Adding;
import com.example.demo.Normal.OrderedMeal;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.OrderedMealDTO;

public class OrderedMealConverter {
    private OrderedMealConverter() {

    }

    public static OrderedMealDTO convertToDTO(OrderedMeal orderedMeal) {
        return OrderedMealDTO.builder()
                .id(orderedMeal.getId())
                .user(orderedMeal.getUserId())
                .meal(orderedMeal.getMealId())
                .build();
    }
}
