package com.example.demo.dto;

import com.mysql.cj.jdbc.Blob;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {
    private int id;
    private CategoryDTO category;
    private String image;
    private String name;
    private String description;
    private double weight;
    private double price;
}