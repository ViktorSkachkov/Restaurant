package com.example.demo.Business.impl;

import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteMealUseCaseImpTest {
    @Mock
    MealRepository mealRepositoryMock;
    @Mock
    CategoryRepository categoryRepositoryMock;
    @InjectMocks
    DeleteMealUseCaseImp deleteMealUseCase;
    @Test
    void deleteMeal() {
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
        deleteMealUseCase.deleteMeal(meal.getId());
        verify(mealRepositoryMock, times(1)).delete(meal);
    }
}