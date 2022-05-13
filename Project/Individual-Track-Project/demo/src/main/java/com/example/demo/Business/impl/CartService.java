package com.example.demo.Business.impl;

import com.example.demo.Repositories.CartRepository;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
   /* CartRepository cdh = new CartRepository();
    public CartService(CartRepository CartDataHelper) {
        this.cdh = CartDataHelper;
    }
    public List<OrderedMealDTO> GetCart() {
        return  cdh.GetOrderedMeals();
    }
    public List<OrderedMealDTO> GetMeals(String username) {
        List<OrderedMealDTO> meals = new ArrayList<>();
        for(OrderedMealDTO m : cdh.GetOrderedMeals()) {
            if(m.getUser().getUsername().equals(username)) {
                meals.add(m);
            }
        }
        return meals;
    }
    public OrderedMealDTO GetOrderedMeal(int id)
    {
        OrderedMealDTO orderedMeal = null;
        for(OrderedMealDTO t: cdh.GetOrderedMeals()) {
            if(t.getId() == id) {
                orderedMeal = t;
                return orderedMeal;
            }
        }
        return null;
    }*/
}
