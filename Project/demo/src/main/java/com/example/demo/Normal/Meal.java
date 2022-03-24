package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Meal {
    private int id;
    private Category category;
    private String image;
    private String name;
    private String description;
    private int weight;
    private double price;
}
