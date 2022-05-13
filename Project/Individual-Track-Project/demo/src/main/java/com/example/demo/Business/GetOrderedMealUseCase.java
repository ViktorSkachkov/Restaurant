package com.example.demo.Business;

import com.example.demo.dto.OrderedMealDTO;

public interface GetOrderedMealUseCase {
    public OrderedMealDTO GetOrderedMeal(int id);
}
