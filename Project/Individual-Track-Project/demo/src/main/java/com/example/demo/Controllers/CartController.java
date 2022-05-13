package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.Business.impl.*;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.*;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final GetOrderedMealsUseCase getOrderedMealsUseCase;
    private final GetOrderItemsUseCase getOrderItemsUseCase;
    private final GetUsersUseCase getUsersUseCase;

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/orderedMeals")
    public List<OrderedMealDTO> GetCart() {
        return getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals();
        //return  getCartUseCase.GetCart();
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/{username}/{id}")
    public List<OrderedMealDTO> GetMeals(@PathVariable(value = "username") final String username, @PathVariable(value = "id") final long id) {
        List<OrderedMealDTO> orderedMealsList = new ArrayList<>();
            UserDTO user = null;
                    for(UserDTO u : getUsersUseCase.getUsers(id).getUsers()) {
                        if(u.getUsername().equals(username)) {
                            user = u;
                        }
                    }
        for(OrderedMealDTO omd : getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals()) {
            if(omd.getUser() == user.getId()) {
                orderedMealsList.add(omd);
            }
        }
        return orderedMealsList;
        //return getMealsUseCase.GetMeals(username);
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/{id}")
    public OrderedMealDTO GetOrderedMeal(@PathVariable int id)
    {
       OrderedMealDTO orderedMeal = null;
        for(OrderedMealDTO omd : getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals()) {
            if(omd.getId() == id) {
                orderedMeal = omd;
            }
        }
        return orderedMeal;
        //return getOrderedMealUseCase.GetOrderedMeal(id);
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/orderItems")
    public List<OrderDTO> GetOrders() {
        return getOrderItemsUseCase.getOrders().getOrders();
        //return  getCartUseCase.GetCart();
    }
}