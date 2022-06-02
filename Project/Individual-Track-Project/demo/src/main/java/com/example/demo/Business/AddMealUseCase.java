package com.example.demo.Business;

import com.example.demo.dto.CreateMealRequestDTO;
import com.example.demo.dto.CreateMealResponseDTO;

public interface AddMealUseCase {
    CreateMealResponseDTO createMeal(CreateMealRequestDTO request);
}
