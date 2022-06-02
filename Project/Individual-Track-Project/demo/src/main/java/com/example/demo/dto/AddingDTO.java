package com.example.demo.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddingDTO{
    private int id;
    private String name;
    private double weight;
    private double price;
}
