package com.example.demo;

import com.example.demo.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
/*
@SpringBootTest
class CartTests {
    MockCartRepository mcdh = new MockCartRepository();
    MockGetCartUseCaseImp mockGetCartUseCaseImp = new MockGetCartUseCaseImp();
    MockGetOrderedMealUseCaseImp mockGetOrderedMealUseCaseImp = new MockGetOrderedMealUseCaseImp();
    MockGetOrderedMealsUseCaseImp mockGetOrderedMealsUseCaseImp = new MockGetOrderedMealsUseCaseImp();
    @Test
    void GetCart()
    {
       UserDTO user1 = UserDTO.builder()
       .id(2)
       .firstName("Pavel")
       .lastName("Dimitrov")
       .username("bomber")
       .password("Jackal")
        .email("pavel.dimitrov01@gmail.com")
         .address("Pieter Breughelstraat 19")
         .phone("43554373753745")
               .build();
        CategoryDTO category = CategoryDTO.builder()
                .index(3)
                .name("Salads")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal1 = MealDTO.builder()
                .id(3)
                .category(category)
                .image("pictures/Caesar.jpg")
                .name("Caesar")
                .description("olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken")
                .weight(350)
                .price(6.99)
                .build();
        AddingDTO adding = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .weight(50)
                .price(1)
                .build();
        List<AddingDTO> addings2 = new ArrayList<>();
        addings2.add(adding);
   OrderedMealDTO orderedMeal  = OrderedMealDTO.builder()
           .id(2)
           .user(user1)
           .meal(meal1)
           .addingList(addings2)
           .totalPrice(6.99)
           .build();
        Assertions.assertEquals(orderedMeal ,mockGetCartUseCaseImp.GetCart().get(1));
    }
    @Test
    void GetOrderedMeal()
    {
        UserDTO user1 = UserDTO.builder()
                .id(2)
                .firstName("Pavel")
                .lastName("Dimitrov")
                .username("bomber")
                .password("Jackal")
                .email("pavel.dimitrov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("43554373753745")
                .build();
        CategoryDTO category = CategoryDTO.builder()
                .index(3)
                .name("Salads")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal1 = MealDTO.builder()
                .id(3)
                .category(category)
                .image("pictures/Caesar.jpg")
                .name("Caesar")
                .description("olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken")
                .weight(350)
                .price(6.99)
                .build();
        AddingDTO adding = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .weight(50)
                .price(1)
                .build();
        List<AddingDTO> addings2 = new ArrayList<>();
        addings2.add(adding);
        OrderedMealDTO orderedMeal  = OrderedMealDTO.builder()
                .id(2)
                .user(user1)
                .meal(meal1)
                .addingList(addings2)
                .totalPrice(6.99)
                .build();
    Assertions.assertEquals(orderedMeal ,mockGetOrderedMealUseCaseImp.GetOrderedMeal(1));
    }
    @Test
    void GetMeals() {
        UserDTO user1 = UserDTO.builder()
                .id(2)
                .firstName("Pavel")
                .lastName("Dimitrov")
                .username("bomber")
                .password("Jackal")
                .email("pavel.dimitrov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("43554373753745")
                .build();
        CategoryDTO category = CategoryDTO.builder()
                .index(3)
                .name("Salads")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal1 = MealDTO.builder()
                .id(3)
                .category(category)
                .image("pictures/Caesar.jpg")
                .name("Caesar")
                .description("olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken")
                .weight(350)
                .price(6.99)
                .build();
        AddingDTO adding = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .weight(50)
                .price(1)
                .build();
        List<AddingDTO> addings2 = new ArrayList<>();
        addings2.add(adding);
        OrderedMealDTO orderedMeal  = OrderedMealDTO.builder()
                .id(1)
                .user(user1)
                .meal(meal1)
                .addingList(addings2)
                .totalPrice(6.99)
                .build();
        Assertions.assertEquals(orderedMeal ,mockGetOrderedMealsUseCaseImp.GetMeals("Pavel").get(0));
    }
}*/
