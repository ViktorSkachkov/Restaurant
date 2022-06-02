package com.example.demo.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private int id;
    private UserDTO user;
    private MealDTO meal;
    private int numberOfItems;
    private String approved;
    private LocalDateTime dateOfOrder;
    private String cutlariesNeeded;
    private List<AddingDTO> addings;
}
