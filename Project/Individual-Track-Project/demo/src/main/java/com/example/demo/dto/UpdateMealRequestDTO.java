package com.example.demo.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMealRequestDTO {
    @NotNull
    @EqualsAndHashCode.Exclude
    private int id;

    @NotBlank
    private String category;

    @NotBlank
    private String image;

    @NotBlank
    private String description;

    @NotNull
    @EqualsAndHashCode.Exclude
    private double weight;

    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;

    @NotBlank
    @Length(min = 2 ,max = 50)
    private String name;
}
