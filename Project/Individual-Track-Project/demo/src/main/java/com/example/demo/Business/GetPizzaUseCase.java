package com.example.demo.Business;

import com.example.demo.dto.GetMealsResponseDTO;
import com.example.demo.dto.MealDTO;
import com.example.demo.dto.*;

import java.util.List;

public interface GetPizzaUseCase {
    /*public List<MealDTO> GetPizza();*/
    GetPizzaResponseDTO getPizza();
}
