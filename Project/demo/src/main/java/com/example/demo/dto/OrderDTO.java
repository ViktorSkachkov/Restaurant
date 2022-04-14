package com.example.demo.dto;

import com.example.demo.Normal.OrderedMeal;
import com.example.demo.Normal.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private int id;
    private UserDTO user;
    private double totalPrice;
    private List<OrderedMealDTO> orderedMealList = new ArrayList<>();
    public void AddMeal(OrderedMealDTO orderedMeal) {
        this.orderedMealList.add(orderedMeal);
    }
    public void RemoveMeal(OrderedMealDTO orderedMeal) {
        this.orderedMealList.remove(orderedMeal);
    }
    public void AddANumberOfMeals(OrderedMealDTO orderedMeal, int number) {

    }
    public boolean RemoveANumberOfMeals(OrderedMealDTO orderedMeal, int number) {
        return true;
    }
}
