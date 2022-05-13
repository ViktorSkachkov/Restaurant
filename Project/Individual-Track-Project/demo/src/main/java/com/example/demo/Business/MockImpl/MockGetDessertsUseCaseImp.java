package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetDessertsUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetDessertsUseCaseImp /*implements GetDessertsUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override
    public List<MealDTO> GetDesserts() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Desserts")) {
                newList.add(m);
            }
        }
        return newList;
    }*/
}
