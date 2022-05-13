package com.example.demo.Business.impl;

import com.example.demo.Business.GetDessertsUseCase;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class GetDessertsUseCaseImp /*implements GetDessertsUseCase*/ {
    private OrderRepository odh = new OrderRepository();
   /* @Override
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
