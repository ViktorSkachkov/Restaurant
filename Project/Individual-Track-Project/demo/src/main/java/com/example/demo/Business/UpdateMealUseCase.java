package com.example.demo.Business;

import com.example.demo.dto.UpdateMealRequestDTO;
import com.example.demo.dto.UpdateMealResponseDTO;

public interface UpdateMealUseCase {
    UpdateMealResponseDTO updateMeal(UpdateMealRequestDTO requestDTO);
}
