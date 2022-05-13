package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetPizzaUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.GetPizzaResponseDTO;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetPizzaUseCaseImp /*implements GetPizzaUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override*/
    /*public List<MealDTO> GetPizza() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Pizza")) {
                newList.add(m);
            }
        }
        return newList;
    }*/
}
