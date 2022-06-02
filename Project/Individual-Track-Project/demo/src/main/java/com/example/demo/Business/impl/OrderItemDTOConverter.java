package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Order;
import com.example.demo.dto.*;

import java.time.format.DateTimeFormatter;

public class OrderItemDTOConverter {
    private OrderItemDTOConverter() {

    }
    public static OrderDTO convertToDTO(Order order) {
        double totalPrice = order.getMeal().getPrice() * order.getNumberOfItems();
        String formatted_time = order.getTimeOfOrder().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        UserDTO userDTO = UserDTO.builder()
                .id(Math.toIntExact(order.getUser().getId()))
                .firstName(order.getUser().getFirstName())
                .lastName(order.getUser().getLastName())
                .username(order.getUser().getUsername())
                .pwd(order.getUser().getPwd())
                .email(order.getUser().getEmail())
                .address(order.getUser().getAddress())
                .phone(order.getUser().getPhone())
                .logged(false)
                .category(order.getUser().getCategory())
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(order.getMeal().getCategory().getId()))
                .name(order.getMeal().getCategory().getName())
                .image(order.getMeal().getCategory().getImage())
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(Math.toIntExact(order.getMeal().getId()))
                .category(categoryDTO)
                .image(order.getMeal().getImage())
                .name(order.getMeal().getName())
                .description(order.getMeal().getDescription())
                .weight(order.getMeal().getWeight())
                .price(order.getMeal().getPrice())
                .build();
        return OrderDTO.builder()
                .id(order.getId())
                .user(userDTO)
                .meal(mealDTO)
                .numberOfItems(order.getNumberOfItems())
                .formatted_time(formatted_time)
                .totalPrice(totalPrice)
                .build();
    }
}
