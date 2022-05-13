package com.example.demo.Controllers;

import com.example.demo.Business.GetAddingsUseCase;
import com.example.demo.Business.GetCategoriesUseCase;
import com.example.demo.Business.GetMealsUseCase;
import com.example.demo.Business.GetPizzaUseCase;
import com.example.demo.Business.impl.*;
import com.example.demo.MockServices.MockOrderService;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private OrderService oa = new OrderService();
    private MockOrderService mockOrderAdministration;
    private GetOrdersUseCaseImp getOrdersUseCaseImp = new GetOrdersUseCaseImp();
   // private GetAddingsUseCaseImp getAddingsUseCaseImp = new GetAddingsUseCaseImp();
    //private GetMealsUseCaseImp getMealsUseCaseImp = new GetMealsUseCaseImp();
    private GetDessertsUseCaseImp getDessertsUseCaseImp = new GetDessertsUseCaseImp();
    private GetSaladsUseCaseImp getSaladsUseCaseImp = new GetSaladsUseCaseImp();
    private GetPastaUseCaseImp getPastaUseCaseImp = new GetPastaUseCaseImp();
    private GetPizzaUseCaseImp getPizzaUseCaseImp = new GetPizzaUseCaseImp();
    private GetMealUseCaseImp getMealUseCaseImp = new GetMealUseCaseImp();
    //private GetCategoriesUseCaseImp getCategoriesUseCaseImp = new GetCategoriesUseCaseImp();

    private final GetMealsUseCase getMealsUseCase;
    private final GetCategoriesUseCase getCategoriesUseCase;
    private final GetAddingsUseCase getAddingsUseCase;
/*@Autowired
    public OrderController(OrderService orderAdministration) {
        this.oa = orderAdministration;
}
    public OrderController(MockOrderService mockOrderAdministration) {
        this.mockOrderAdministration = mockOrderAdministration;
    }*/
    public List<OrderDTO> GetOrders() {
        return getOrdersUseCaseImp.GetOrders();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/Addings")
    public List<AddingDTO> GetAddings() {
       return getAddingsUseCase.getAddings().getAddings();
        /*return getAddingsUseCaseImp.GetAddings();*/
    }


    /*@GetMapping("/Meals")
    public List<MealDTO> GetMeals() {
        return getMealsUseCaseImp.GetMeals();
    }*/
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Meals")
    public List<MealDTO> getMeals() {
        return getMealsUseCase.getMeals().getMeals();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Desserts")
    public List<MealDTO> GetDesserts() {
        List<MealDTO> desserts = new ArrayList<>();
                for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
                    if(meal.getCategory() == 4) {
                        desserts.add(meal);
                    }
                }
                return desserts;
        /*return getDessertsUseCaseImp.GetDesserts();*/
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Salads")
    public List<MealDTO> GetSalads() {
        List<MealDTO> salads = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory() == 3) {
                salads.add(meal);
            }
        }
        return salads;
        /*return getSaladsUseCaseImp.GetSalads();*/
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Pasta")
    public List<MealDTO> GetPasta() {
        List<MealDTO> pasta = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory() == 2) {
                pasta.add(meal);
            }
        }
        return pasta;
    /*return getPastaUseCaseImp.GetPasta();*/
    }

    /*@GetMapping("/Pizza")
    public List<MealDTO> GetPizza() {
        return getPizzaUseCaseImp.GetPizza();
    }*/
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Pizza")
    public List<MealDTO> getPizza() {
        List<MealDTO> pizza = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory() == 1) {
                pizza.add(meal);
            }
        }
        return pizza;
       /*return getPizzaUseCase.getPizza();*/
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/{id}")
    public MealDTO GetMeal(@PathVariable int id) {
        return getMealUseCaseImp.GetMeal(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Categories")
    public List<CategoryDTO> GetCategories() {
        return getCategoriesUseCase.getCategories().getCategories();
    }
    /*@GetMapping("categoryIds")
    public List<Integer> GetCategoryIds() {
        List<Integer> ids = new ArrayList<>();
        for(CategoryDTO category: categories) {
                ids.add(category.getIndex());
        }
        return ids;
    }
    @GetMapping("categoryImages")
    public List<String> GetCategoryImages() {
        List<String> images = new ArrayList<>();
        for(CategoryDTO category: categories) {
                images.add(category.getImage());
        }
        return images;
    }
    @GetMapping("categoryNames")
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
