package com.example.demo.Business.impl;

import com.example.demo.Business.*;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.OrderItemRepository;
import com.example.demo.dto.GetOrderItemsResponseDTO;
import com.example.demo.dto.GetOrderedMealsResponseDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderedMealDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderItemsUseCaseImp implements GetOrderItemsUseCase {
    private final OrderItemRepository orderItemRepository;
    @Override
    public GetOrderItemsResponseDTO getOrders() {
        List<OrderDTO> orderItems = orderItemRepository.findAll()
                .stream()
                .map(OrderItemDTOConverter::convertToDTO)
                .toList();

        return GetOrderItemsResponseDTO.builder()
                .orders(orderItems)
                .build();
    }
}
