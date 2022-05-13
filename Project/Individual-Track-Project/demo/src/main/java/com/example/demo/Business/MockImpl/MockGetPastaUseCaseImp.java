package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetPastaUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.MealDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetPastaUseCaseImp /*implements GetPastaUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
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
