package com.example.demo.Business.impl;

import com.example.demo.Business.GetOrderedMealsUseCase;
import com.example.demo.Repositories.*;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.GetAddingsResponseDTO;
import com.example.demo.dto.GetOrderedMealsResponseDTO;
import com.example.demo.dto.OrderedMealDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderedMealsUseCaseImp implements GetOrderedMealsUseCase {
    private final OrderedMealRepository orderedMealRepository;
    @Override
    public GetOrderedMealsResponseDTO getOrderedMeals() {
        List<OrderedMealDTO> orderedMealsItems = orderedMealRepository.findAll()
                .stream()
                .map(OrderedMealConverter::convertToDTO)
                .toList();

        return GetOrderedMealsResponseDTO.builder()
                .orderedMeals(orderedMealsItems)
                .build();
    }
   /* private CartRepository odh = new CartRepository();
    @Override
    public List<OrderedMealDTO> GetMeals(String username) {
        List<OrderedMealDTO> meals = new ArrayList<>();
        for(OrderedMealDTO m : odh.GetOrderedMeals()) {
            if(m.getUser().getUsername().equals(username)) {
                meals.add(m);
            }
        }
        return meals;
    }*/
}
