package com.example.demo.Business.impl;

import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.dto.GetCategoriesResponseDTO;
import com.example.demo.dto.UpdateMealRequestDTO;
import com.example.demo.dto.UpdateMealResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateMealUseCaseImpTest {
    @Mock
    private MealRepository mealRepositoryMock;
    @Mock
    private CategoryRepository categoryRepositoryMock;
    @InjectMocks
    UpdateMealUseCaseImp updateMealUseCase;
    @Test
    void updateMeal() {
        Category category = Category.builder()
                .id(1L)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        List<Category> categoryList = categoryRepositoryMock.findAll();
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
        List<Meal> mealList = mealRepositoryMock.findAll();
        assertEquals(meal, mealList.get(0));
Meal newMeal = Meal.builder()
                .image("")
                .description("ggggggggggggggggggggggggggggggg")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        UpdateMealRequestDTO updateMealRequestDTO = UpdateMealRequestDTO.builder()
                .id(2)
                .image("")
                .description("ggggggggggggggggggggggggggggggg")
                .name("Baked Feta")
                .category("Pasta")
                .weight(350)
                .price(7.99)
                .build();
        when(mealRepositoryMock.findById((long) updateMealRequestDTO.getId())).thenReturn(Optional.of(meal));
        Optional<Meal> mealOptional = mealRepositoryMock.findById(meal.getId());
        when(mealRepositoryMock.save(newMeal)).thenReturn(newMeal);
        Meal actualMeal = mealRepositoryMock.save(newMeal);
        UpdateMealResponseDTO updateMealResponseDTO = updateMealUseCase.updateMeal(updateMealRequestDTO);
        assertEquals("Baked Feta", updateMealResponseDTO.getMealName());
        //assertEquals(newMeal, actualMeal);
        //UpdateMealResponseDTO updateMealResponseDTO = updateMealUseCase.updateMeal(updateMealRequestDTO);
    }
}