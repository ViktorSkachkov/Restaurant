package com.example.demo.MockServices;

import com.example.demo.MockRepositories.*;
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
public class MockOrderService {
    private MockOrderRepository modh = new MockOrderRepository();
    public MockOrderService(MockOrderRepository MockOrderDataHelper) {
        this.modh = MockOrderDataHelper;
    }
    public List<OrderDTO> GetOrders() {
        return this.modh.GetOrders();
    }

    public List<AddingDTO> GetAddings() {
        return this.modh.GetAddings();
    }

    public List<MealDTO> GetMeals() {
        return this.modh.GetMeals();
    }

   /* public List<MealDTO> GetDesserts() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : modh.GetMeals()) {
            if(m.getCategory().getName().equals("Desserts")) {
                newList.add(m);
            }
        }
        return newList;
    }


    public List<MealDTO> GetSalads() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : modh.GetMeals()) {
            if(m.getCategory().getName().equals("Salads")) {
                newList.add(m);
            }
        }
        return newList;
    }


    public List<MealDTO> GetPasta() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : modh.GetMeals()) {
            if(m.getCategory().getName().equals("Pasta")) {
                newList.add(m);
            }
        }
        return newList;
    }


    public List<MealDTO> GetPizza() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : modh.GetMeals()) {
            if(m.getCategory().getName().equals("Pizza")) {
                newList.add(m);
            }
        }
        return newList;
    }*/


    public MealDTO GetMeal(int id) {
        MealDTO meal = null;
        for(MealDTO m : modh.GetMeals()) {
            if(m.getId() == id) {
                meal = m;
            }
        }
        return meal;
    }



    public List<CategoryDTO> GetCategories() {
        return this.modh.GetCategories();
    }

    public List<Integer> GetCategoryIds() {
        List<Integer> ids = new ArrayList<>();
        for(CategoryDTO category: modh.GetCategories()) {
            ids.add(category.getId());
        }
        return ids;
    }

    public List<String> GetCategoryImages() {
        List<String> images = new ArrayList<>();
        for(CategoryDTO category: modh.GetCategories()) {
            images.add(category.getImage());
        }
        return images;
    }

    public List<String> GetCategoryNames() {
        List<String> names = new ArrayList<>();
        for(CategoryDTO category: modh.GetCategories()) {
            names.add(category.getName());
        }
        return names;
    }
}
