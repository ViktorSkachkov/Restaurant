package com.example.demo.MockControllers;

import com.example.demo.Business.MockImpl.*;
import com.example.demo.MockServices.MockOrderService;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/mockOrders/")
public class MockOrderController {
    private MockOrderService moa = new MockOrderService();
    private MockGetOrdersUseCaseImp getOrdersUseCaseImp = new MockGetOrdersUseCaseImp();
    private MockGetAddingsUseCaseImp getAddingsUseCaseImp = new MockGetAddingsUseCaseImp();
    private MockGetMealsUseCaseImp getMealsUseCaseImp = new MockGetMealsUseCaseImp();
    private MockGetDessertsUseCaseImp getDessertsUseCaseImp = new MockGetDessertsUseCaseImp();
    private MockGetSaladsUseCaseImp getSaladsUseCaseImp = new MockGetSaladsUseCaseImp();
    private MockGetPastaUseCaseImp getPastaUseCaseImp = new MockGetPastaUseCaseImp();
    private MockGetPizzaUseCaseImp getPizzaUseCaseImp = new MockGetPizzaUseCaseImp();
    private MockGetMealUseCaseImp getMealUseCaseImp = new MockGetMealUseCaseImp();
    private MockGetCategoriesUseCaseImp getCategoriesUseCaseImp = new MockGetCategoriesUseCaseImp();
    @Autowired
    public MockOrderController(MockOrderService mockOrderAdministration) {
        this.moa = mockOrderAdministration;
    }
    public List<OrderDTO> GetOrders() {
        return this.getOrdersUseCaseImp.GetOrders();
    }

    @GetMapping("MockAddings")
    public List<AddingDTO> GetAddings() {
        return this.getAddingsUseCaseImp.GetAddings();
    }


    @GetMapping("MockMeals")
    public List<MealDTO> GetMeals() {
        return this.getMealsUseCaseImp.GetMeals();
    }

    @GetMapping("MockDeserts")
    public List<MealDTO> GetDesserts() {
  /*return this.getDessertsUseCaseImp.GetDesserts();*/
        return null;
    }

    @GetMapping("MockSalads")
    public List<MealDTO> GetSalads() {
        /*return this.getSaladsUseCaseImp.GetSalads();*/
        return null;
    }

    @GetMapping("MockPasta")
    public List<MealDTO> GetPasta() {
        /*return this.getPastaUseCaseImp.GetPasta();*/
        return null;
    }

    @GetMapping("MockPizza")
    public List<MealDTO> GetPizza() {
        /*return this.getPizzaUseCaseImp.GetPizza();*/
        return null;
    }

    @GetMapping("{id}")
    public MealDTO GetMeal(@PathVariable int id) {
       return this.getMealUseCaseImp.GetMeal(id);
    }


    @GetMapping("MockCategories")
    public List<CategoryDTO> GetCategories() {
        /*return this.getCategoriesUseCaseImp.GetCategories();*/
        return null;
    }
    /*@GetMapping("MockcategoryIds")
    public List<Integer> GetCategoryIds() {
        List<Integer> ids = new ArrayList<>();
        for(CategoryDTO category: categories) {
            ids.add(category.getIndex());
        }
        return ids;
    }
    @GetMapping("MockcategoryImages")
    public List<String> GetCategoryImages() {
        List<String> images = new ArrayList<>();
        for(CategoryDTO category: categories) {
            images.add(category.getImage());
        }
        return images;
    }
    @GetMapping("MockcategoryNames")
    public List<String> GetCategoryNames() {
        List<String> names = new ArrayList<>();
        for(CategoryDTO category: categories) {
            names.add(category.getName());
        }
        return names;
    }*/

    public OrderDTO GetOrder() {
        return null;
    }
}
