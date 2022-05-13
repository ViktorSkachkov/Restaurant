package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetOrderedMealUseCase;
import com.example.demo.MockRepositories.MockCartRepository;
import com.example.demo.dto.OrderedMealDTO;

public class MockGetOrderedMealUseCaseImp implements GetOrderedMealUseCase {
    MockCartRepository cdh = new MockCartRepository();
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
