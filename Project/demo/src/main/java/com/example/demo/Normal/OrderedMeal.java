package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.*;

@Data
@AllArgsConstructor
public class OrderedMeal {
    private int id;
    private User user;
    private double totalPrice;
    private List<Adding> addingList;
    public void AddAdding(Adding adding) {
        this.addingList.add(adding);
    }
    public void RemoveAdding(Adding adding) {
        this.addingList.remove(adding);
    }
}
