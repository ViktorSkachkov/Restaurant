package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Order;
import com.example.demo.Repositories.OrderItemRepository;
import com.example.demo.dto.GetOrderItemsResponseDTO;
import com.example.demo.dto.OrderDTO;
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
class GetOrderItemsUseCaseImpTest {
    @Mock
    private OrderItemRepository orderItemRepositoryMock;

    @InjectMocks
    private GetOrderItemsUseCaseImp getOrderItemsUseCase;

    @Test
    void getOrderItems() {
        Order order = Order.builder()
                .id(1L)
                .user(2)
                .orderedMeal(1)
                .build();
        when(orderItemRepositoryMock.findAll()).thenReturn(List.of(order));
        GetOrderItemsResponseDTO actualResult = getOrderItemsUseCase.getOrders();
        OrderDTO orderDTO = OrderDTO.builder()
                .id(1L)
                .userId(2)
                .orderedMealId(1)
                .build();
        GetOrderItemsResponseDTO expectedResult = GetOrderItemsResponseDTO.builder()
                .orders(List.of(orderDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(orderItemRepositoryMock).findAll();
    }
}