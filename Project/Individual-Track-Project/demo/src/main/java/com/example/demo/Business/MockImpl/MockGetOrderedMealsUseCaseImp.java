package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetOrderedMealsUseCase;
import com.example.demo.MockRepositories.MockCartRepository;
import com.example.demo.dto.OrderedMealDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetOrderedMealsUseCaseImp /*implements GetOrderedMealsUseCase*/ {
    private MockCartRepository odh = new MockCartRepository();
    /*@Override*/
    public List<OrderedMealDTO> GetMeals(String username) {
        List<OrderedMealDTO> meals = new ArrayList<>();
        for(OrderedMealDTO m : odh.GetOrderedMeals()) {
            //if(m.getUser().getUsername().equals(username)) {
                meals.add(m);
           // }
        }
        return meals;
    }
}
