package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetMealsUseCaseImpTest {
    @Mock
    private MealRepository mealRepositoryMock;

    @InjectMocks
    private GetMealsUseCaseImp getMealsUseCase;
   @Test
    void getMeals() {
       Meal meal = Meal.builder()
               .id(1L)
               //.category(2)
               .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
               .image("/pictures/lasagna.jpg")
               .name("Lasagna")
               .weight(400)
               .price(8.99)
               .build();
       when(mealRepositoryMock.findAll()).thenReturn(List.of(meal));
       GetMealsResponseDTO actualResult = getMealsUseCase.getMeals();
       MealDTO mealDTO = MealDTO.builder()
               .id(1)
              // .category(2)
               .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
               .image("/pictures/lasagna.jpg")
               .name("Lasagna")
               .weight(400)
               .price(8.99)
               .build();
       GetMealsResponseDTO expectedResult = GetMealsResponseDTO.builder()
               .meals(List.of(mealDTO))
               .build();
       assertEquals(expectedResult, actualResult);
       verify(mealRepositoryMock).findAll();
   }
}