package com.example.demo.Business;

import com.example.demo.dto.GetOrderedMealsResponseDTO;
import com.example.demo.dto.OrderedMealDTO;

import java.util.List;

public interface GetCartUseCase {
    List<OrderedMealDTO> getCart();
}
