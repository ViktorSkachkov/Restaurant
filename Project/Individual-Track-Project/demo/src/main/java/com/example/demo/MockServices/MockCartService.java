package com.example.demo.MockServices;

import com.example.demo.MockRepositories.MockCartRepository;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockCartService {
    MockCartRepository mcdh = new MockCartRepository();
    public MockCartService(MockCartRepository MockCartDataHelper) {
        this.mcdh = MockCartDataHelper;
    }
    public List<OrderedMealDTO> GetCart() {
        return  mcdh.GetOrderedMeals();
    }
    public List<OrderedMealDTO> GetMeals(String username) {
        List<OrderedMealDTO> meals = new ArrayList<>();
        for(OrderedMealDTO m : mcdh.GetOrderedMeals()) {
            //if(m.getUser().getUsername().equals(username)) {
                meals.add(m);
           // }
        }
        return meals;
    }
    public OrderedMealDTO GetOrderedMeal(int id)
    {
        OrderedMealDTO orderedMeal = null;
        for(OrderedMealDTO t: mcdh.GetOrderedMeals()) {
            if(t.getId() == id) {
                orderedMeal = t;
                return orderedMeal;
            }
        }
        return null;
    }

}
