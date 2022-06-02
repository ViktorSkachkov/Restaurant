package com.example.demo.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private MealDTO meal;
    private int numberOfItems;
    private String formatted_time;
    private double totalPrice;
}
