package com.example.demo.Business.impl;

import com.example.demo.Business.GetSaladsUseCase;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class GetSaladsUseCaseImp /*implements GetSaladsUseCase*/ {
    private OrderRepository odh = new OrderRepository();
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
