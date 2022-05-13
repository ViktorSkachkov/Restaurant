package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;
import com.example.demo.dto.OrderDTO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository odh = new OrderRepository();
    public OrderService(OrderRepository odh) {
        this.odh = odh;
    }
    public List<OrderDTO> GetOrders() {
        return this.odh.GetOrders();
    }

    public List<AddingDTO> GetAddings() {
        return this.odh.GetAddings();
    }

    public List<MealDTO> GetMeals() {
        return this.odh.GetMeals();
    }

    /*public List<MealDTO> GetDesserts() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Desserts")) {
                newList.add(m);
            }
        }
        return newList;
    }


    public List<MealDTO> GetSalads() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Salads")) {
                newList.add(m);
            }
        }
        return newList;
    }


    public List<MealDTO> GetPasta() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Pasta")) {
                newList.add(m);
            }
        }
        return newList;
    }

    public List<MealDTO> GetPizza() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : odh.GetMeals()) {
            if(m.getCategory().getName().equals("Pizza")) {
                newList.add(m);
            }
        }
        return newList;
    }*/

    public MealDTO GetMeal(int id) {
        MealDTO meal = null;
        for(MealDTO m : odh.GetMeals()) {
            if(m.getId() == id) {
                meal = m;
            }
        }
        return meal;
    }

    public List<CategoryDTO> GetCategories() {
        return odh.GetCategories();
    }

   /* public List<Integer> GetCategoryIds() {
        List<Integer> ids = new ArrayList<>();
        for(CategoryDTO category: categories) {
            ids.add(category.getIndex());
        }
        return ids;
    }

    public List<String> GetCategoryImages() {
        List<String> images = new ArrayList<>();
        for(CategoryDTO category: categories) {
            images.add(category.getImage());
        }
        return images;
    }

    public List<String> GetCategoryNames() {
        List<String> names = new ArrayList<>();
        for(CategoryDTO category: categories) {
            names.add(category.getName());
        }
        return names;
    }*/
   /* public OrderDataHelper GetOrderDataHelper() {
        return this.orderDataHelper;
    }*/
}
