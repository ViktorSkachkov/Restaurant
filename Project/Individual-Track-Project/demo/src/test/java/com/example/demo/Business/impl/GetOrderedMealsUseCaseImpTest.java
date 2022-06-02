package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.OrderedMeal;
import com.example.demo.Repositories.OrderedMealRepository;
import com.example.demo.dto.GetOrderedMealsResponseDTO;
import com.example.demo.dto.OrderedMealDTO;
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
class GetOrderedMealsUseCaseImpTest {
    @Mock
    private OrderedMealRepository orderedMealRepositoryMock;

    @InjectMocks
    private GetOrderedMealsUseCaseImp getOrderedMealsUseCase;

    @Test
    void getCart() {
        OrderedMeal orderedMeal = OrderedMeal.builder()
                .id(1L)
                .mealId(2)
                .userId(3)
                .build();
        when(orderedMealRepositoryMock.findAll()).thenReturn(List.of(orderedMeal));
        GetOrderedMealsResponseDTO actualResult = getOrderedMealsUseCase.getOrderedMeals();
        OrderedMealDTO orderedMealDTO = OrderedMealDTO.builder()
                .id(1)
                .meal(2)
                .user(3)
                .build();
        GetOrderedMealsResponseDTO expectedResult = GetOrderedMealsResponseDTO.builder()
                .orderedMeals(List.of(orderedMealDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(orderedMealRepositoryMock).findAll();
    }
}