package com.example.demo.Business;

import com.example.demo.dto.GetMealsResponseDTO;
import com.example.demo.dto.GetOrderedMealsResponseDTO;
import com.example.demo.dto.OrderedMealDTO;

import java.util.List;

public interface GetOrderedMealsUseCase {
    //public List<OrderedMealDTO> GetMeals(String username);
    GetOrderedMealsResponseDTO getOrderedMeals();
}
