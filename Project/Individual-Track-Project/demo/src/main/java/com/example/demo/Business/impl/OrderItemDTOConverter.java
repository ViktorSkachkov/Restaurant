package com.example.demo.Business.impl;

import com.example.demo.Normal.Order;
import com.example.demo.Normal.User;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderedMealDTO;
import com.example.demo.dto.UserDTO;

public class OrderItemDTOConverter {
    private OrderItemDTOConverter() {

    }
    public static OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUser())
                .orderedMealId(order.getOrderedMeal())
                .build();
    }
}
