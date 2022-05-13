package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetPizzaResponseDTO {
    private List<MealDTO> pizza;
}
