package com.example.demo.Controllers;

import com.example.demo.Administrations.*;
import com.example.demo.MockAdministration.*;
import com.example.demo.Normal.*;

import java.util.*;


public class CartController {
    private CartAdministration cartAdministration;
    private MockCartAdministration mockCartAdministration;
    private List<OrderedMeal> orderedMeals;
    CartController(CartAdministration cartAdministration) {
        this.cartAdministration = cartAdministration;
    }
    CartController(MockCartAdministration mockCartAdministration) {
        this.mockCartAdministration = mockCartAdministration;
    }
    public List<OrderedMeal> GetCart() {
        return  orderedMeals;
    }
}