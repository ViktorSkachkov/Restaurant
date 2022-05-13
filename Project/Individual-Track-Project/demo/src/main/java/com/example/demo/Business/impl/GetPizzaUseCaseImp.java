package com.example.demo.Business.impl;

import com.example.demo.Business.GetPizzaUseCase;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.GetPizzaResponseDTO;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class GetPizzaUseCaseImp /*implements GetPizzaUseCase*/ {
    private OrderRepository odh = new OrderRepository();
   /* @Override
    public List<MealDTO> GetPizza() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Pizza")) {
                newList.add(m);
            }
        }
        return newList;
    }*/

   /* @Override
    public GetPizzaResponseDTO getPizza() {
        return null;
    }*/
}
