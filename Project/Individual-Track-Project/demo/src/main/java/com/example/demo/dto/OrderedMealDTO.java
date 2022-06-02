package com.example.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedMealDTO {
    private int id;
    private int user;
    private int meal;
    private List<AddingDTO> addingList = new ArrayList<>();
    private double totalPrice;

    public void AddAdding(AddingDTO adding) {
        this.addingList.add(adding);
    }
    public void RemoveAdding(AddingDTO adding) {
        this.addingList.remove(adding);
    }

}
