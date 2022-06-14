package com.example.demo.Business.impl;

import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetMealsUseCaseImpTest {
    @Mock
    private MealRepository mealRepositoryMock;

    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private GetMealsUseCaseImp getMealsUseCase;

    @InjectMocks
    private GetCategoriesUseCaseImp getCategoriesUseCase;
   @Test
    void getMeals() {
       Category category = Category.builder()
               .id(2L)
               .image("lasagna.jpg")
               .name("Pasta")
               .build();

       when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        GetCategoriesResponseDTO categoriesResponseDTO = getCategoriesUseCase.getCategories();
       Meal meal = Meal.builder()
               .id(2L)
               .category(category)
               .description("tomatoes, beef, parmesan, onion, garlic, parsley, oregano, bell pepper")
               .image("lasagna.jpg")
               .name("Lasagna")
               .weight(400)
               .price(8.99)
               .build();

       when(mealRepositoryMock.findAll()).thenReturn(List.of(meal));
       GetMealsResponseDTO actualResult = getMealsUseCase.getMeals();
       CategoryDTO categoryDto = CategoryDTO.builder()
               .id(2)
               .image("lasagna.jpg")
               .name("Pasta")
               .build();
       MealDTO mealDTO = MealDTO.builder()
               .id(2)
               .category(categoryDto)
               .description("tomatoes, beef, parmesan, onion, garlic, parsley, oregano, bell pepper")
               .image("lasagna.jpg")
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