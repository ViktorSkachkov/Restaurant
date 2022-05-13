package com.example.demo.Business.impl;

import com.example.demo.Business.GetPastaUseCase;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class GetPastaUseCaseImp /*implements GetPastaUseCase*/ {
    private OrderRepository odh = new OrderRepository();
    /*@Override
    public List<MealDTO> GetPasta() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Pasta")) {
                newList.add(m);
            }
        }
        return newList;
    }*/
}
