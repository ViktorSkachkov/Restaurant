package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartItemRequestDTO {
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfItems;

    @NotNull
    MealDTO meal;

    @NotNull
    UserDTO user;

    List<Integer> addings;
}
