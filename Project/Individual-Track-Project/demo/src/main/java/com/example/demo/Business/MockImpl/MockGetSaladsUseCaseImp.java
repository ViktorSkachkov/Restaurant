package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetSaladsUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetSaladsUseCaseImp /*implements GetSaladsUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override
    public List<MealDTO> GetSalads() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Salads")) {
                newList.add(m);
            }
        }
        return newList;
    }*/
}
