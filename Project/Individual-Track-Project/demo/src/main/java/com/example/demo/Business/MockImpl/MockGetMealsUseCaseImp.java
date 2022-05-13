package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetMealsUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.List;

public class MockGetMealsUseCaseImp /*implements GetMealsUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override*/
    public List<MealDTO> GetMeals() {
        return this.odh.GetMeals();
    }
}
