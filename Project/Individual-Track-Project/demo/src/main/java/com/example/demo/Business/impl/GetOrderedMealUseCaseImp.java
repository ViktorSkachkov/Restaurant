package com.example.demo.Business.impl;

import com.example.demo.Business.GetOrderedMealUseCase;
import com.example.demo.Repositories.CartRepository;
import com.example.demo.dto.OrderedMealDTO;

public class GetOrderedMealUseCaseImp implements GetOrderedMealUseCase {
    CartRepository cdh = new CartRepository();
    @Override
    public OrderedMealDTO GetOrderedMeal(int id) {
        OrderedMealDTO orderedMeal = null;
        for(OrderedMealDTO t: cdh.GetOrderedMeals()) {
            if(t.getId() == id) {
                orderedMeal = t;
                return orderedMeal;
            }
        }
        return null;
    }
}
