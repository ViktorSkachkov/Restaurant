package com.example.demo.Business.impl;

import com.example.demo.Business.GetMealsUseCase;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.GetMealsResponseDTO;
import com.example.demo.dto.GetTableItemsResponseDTO;
import com.example.demo.dto.MealDTO;
import com.example.demo.dto.TableItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class GetMealsUseCaseImp implements GetMealsUseCase {
    private final MealRepository mealRepository;
    @Override
    public GetMealsResponseDTO getMeals() {
        List<MealDTO> mealItems = mealRepository.findAll()
                .stream()
                .map(MealDTOConverter::convertToDTO)
                .toList();

        return GetMealsResponseDTO.builder()
                .meals(mealItems)
                .build();
    }
   /* private OrderRepository odh = new OrderRepository();
    @Override
    public List<MealDTO> GetMeals() {
        return this.odh.GetMeals();
    }

    @Override
    public GetMealsResponseDTO getMeals() {
        return null;
    }*/
}
