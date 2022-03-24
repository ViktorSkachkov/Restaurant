package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.Ordered;

import java.util.ArrayList;
import java.util.*;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private User user;
    private double totalPrice;
    private List<OrderedMeal> orderedMealList;
    public void AddMeal(OrderedMeal orderedMeal) {
        this.orderedMealList.add(orderedMeal);
    }
    public void RemoveMeal(OrderedMeal orderedMeal) {
        this.orderedMealList.remove(orderedMeal);
    }
    public void AddANumberOfMeals(OrderedMeal orderedMeal, int number) {

    }
    public boolean RemoveANumberOfMeals(OrderedMeal orderedMeal, int number) {
        return true;
    }
}
