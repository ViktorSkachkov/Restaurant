package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
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
class AddMealUseCaseImpTest {
    @Mock
    private MealRepository mealRepositoryMock;
    @Mock
    private CategoryRepository categoryRepositoryMock;
    @InjectMocks
    private GetCategoriesUseCaseImp getCategoriesUseCase;
    @InjectMocks
    private GetMealsUseCaseImp getMealsUseCase;
    @InjectMocks
    private AddMealUseCaseImp addMealUseCase;
    @Test
    void addMeal() {
        Category category = Category.builder()
                .id(1L)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        GetCategoriesResponseDTO actualResult = getCategoriesUseCase.getCategories();
        CreateMealRequestDTO createMealRequestDTO = CreateMealRequestDTO.builder()
                .category("Pasta")
                .description("tomatoes, beef, parmesan, onion, garlic, parsley, oregano, bell pepper")
                .image("lasagna.jpg")
                .name("Lasagna")
                .weight(400)
                .price(8.99)
                .build();
        Meal meal = Meal.builder()
                .id(2L)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        when(mealRepositoryMock.findAll()).thenReturn(List.of(meal));
        GetMealsResponseDTO getMealsResponseDTO = getMealsUseCase.getMeals();
        CategoryDTO categoryDTO = actualResult.getCategories().get(0);
        Category category2 = Category.builder()
                .id((long) categoryDTO.getId())
                .name(categoryDTO.getName())
                .image(categoryDTO.getImage())
                .build();
        Meal newMeal = Meal.builder()
                .image(createMealRequestDTO.getImage())
                .description(createMealRequestDTO.getDescription())
                .name(createMealRequestDTO.getName())
                .category(category)
                .weight(createMealRequestDTO.getWeight())
                .price(createMealRequestDTO.getPrice())
                .build();
        when(mealRepositoryMock.save(newMeal)).thenReturn(newMeal);
        CreateMealResponseDTO createMealResponseDTO = addMealUseCase.createMeal(createMealRequestDTO);
        String savedName = createMealResponseDTO.getMealName();
        assertEquals(newMeal.getName(), savedName);
        verify(mealRepositoryMock).save(newMeal);
    }
}