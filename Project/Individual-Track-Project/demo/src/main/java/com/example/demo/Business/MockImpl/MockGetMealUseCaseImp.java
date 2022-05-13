package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetMealUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.MealDTO;

public class MockGetMealUseCaseImp implements GetMealUseCase {
    private MockOrderRepository odh = new MockOrderRepository();
    @Override
    public MealDTO GetMeal(int id) {
        MealDTO meal = null;
        for(MealDTO m : odh.GetMeals()) {
            if(m.getId() == id) {
                meal = m;
            }
        }
        return meal;
    }
}
