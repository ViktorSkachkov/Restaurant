package com.example.demo;

import com.example.demo.MockAdministration.MockCartAdministration;
import com.example.demo.MockControllers.MockCartController;
import com.example.demo.MockDataHelpers.MockCartDataHelper;
import com.example.demo.Normal.OrderedMeal;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.*;
import com.example.demo.Normal.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CartTests {
    MockCartDataHelper mcdh = new MockCartDataHelper();
    MockCartAdministration mca = new MockCartAdministration(mcdh);
    MockCartController mcc = new MockCartController(mca);

    @Test
    void GetCart()
    {
       UserDTO user = UserDTO.builder()
       .id(2)
       .firstName("Pavel")
       .lastName("Dimitrov")
       .username("bomber")
       .password("Jackal")
        .email("pavel.dimitrov01@gmail.com")
         .address("Pieter Breughelstraat 19")
         .phone("43554373753745")
               .build();
        Assertions.assertEquals(user ,mcc.GetCart().get(1).getUser());
    }
    @Test
    void GetOrderedMeal()
    {
        CategoryDTO c2 = new CategoryDTO(2,"Pasta", "./pictures/lasagna.jpg");
        MealDTO meal = MealDTO.builder()
        .id(1)
        .category(c2)
        .image("/pictures/lasagna.jpg")
        .name("Lasagna")
        .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
        .weight(400)
        .price(8.99)
        .build();
    Assertions.assertEquals(meal ,mcc.GetOrderedMeal(1).getMeal());
    }
    @Test
    void GetMeals() {
        CategoryDTO c1 = new CategoryDTO(1,"Pizza", "./pictures/lasagna.jpg");
        MealDTO meal = MealDTO.builder()
                .id(2)
                .category(c1)
                .image("/pictures/margherita.jpg")
                .name("Margherita")
                .description("crushed San Marzano tomato sauce, mozzarella, basil, olive oil")
                .weight(450)
                .price(5.99)
                .build();
        Assertions.assertEquals(meal ,mcc.GetMeals("Pavel").get(0).getMeal());
    }
}
