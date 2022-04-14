package com.example.demo;

import com.example.demo.MockControllers.MockOrderController;
import com.example.demo.MockAdministration.MockOrderAdministration;
import com.example.demo.MockDataHelpers.MockOrderDataHelper;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTests {
    MockOrderDataHelper modh = new MockOrderDataHelper();
    MockOrderAdministration moa = new MockOrderAdministration(modh);
    MockOrderController moc = new MockOrderController(moa);
    @Test
     void GetAddings() {
        AddingDTO adding = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .weight(50)
                .price(1)
                .build();
         Assertions.assertEquals(adding, moc.GetAddings().get(1));
    }
    @Test
     void GetMeals() {
        CategoryDTO c2 = CategoryDTO.builder()
                .index(2)
                .name("Pasta")
                .image("./pictures/lasagna.jpg")
                .build();
               MealDTO meal = MealDTO.builder()
                .id(2)
                .category(c2)
                .image("/pictures/lasagna.jpg")
                .name("Lasagna")
                .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
                .weight(400)
                .price(8.99)
                .build();
        Assertions.assertEquals(meal, moc.GetMeals().get(1));
    }
    @Test
     void GetDeserts() {
        CategoryDTO c4 = CategoryDTO.builder()
                .index(4)
                .name("Deserts")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(16)
                .category(c4)
                .image("pictures/piePumpkin.jpg")
                .name("Pumpkin pie")
                .description("pumpkin, sugar, eggs, cinnamon, ginger, heavy cream")
                .weight(250)
                .price(3.99)
                .build();
       Assertions.assertEquals(meal, moc.GetDeserts().get(1));
    }
    @Test
     void GetSalads() {
        CategoryDTO c3 = CategoryDTO.builder()
                .index(3)
                .name("Salads")
                .image("./pictures/lasagna.jpg")
                .build();
       new MealDTO(23, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99);
        MealDTO meal = MealDTO.builder()
                .id(23)
                .category(c3)
                .image("pictures/Caesar.jpg")
                .name("Caesar")
                .description("olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken")
                .weight(350)
                .price(6.99)
                .build();
Assertions.assertEquals(meal, moc.GetSalads().get(1));
    }
    @Test
     void GetPasta() {
        CategoryDTO c2 = CategoryDTO.builder()
                .index(2)
                .name("Pasta")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .category(c2)
                .image("/pictures/lasagna.jpg")
                .name("Lasagna")
                .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
                .weight(400)
                .price(8.99)
                .build();
Assertions.assertEquals(meal, moc.GetPasta().get(1));
    }
    @Test
     void GetPizza() {
        CategoryDTO c1 = CategoryDTO.builder()
                .index(1)
                .name("Pizza")
                .image("./pictures/lasagna.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(9)
                .category(c1)
                .image("pictures/margherita.jpg")
                .name("Margherita")
                .description("crushed San Marzano tomato sauce, mozzarella, basil, olive oil")
                .weight(450)
                .price(5.99)
                .build();
        Assertions.assertEquals(meal, moc.GetPizza().get(1));
    }
    @Test
     void GetMeal() {
        CategoryDTO c2 = CategoryDTO.builder()
                .index(2)
                .name("Pasta")
                .image("./pictures/lasagna.jpg")
                .build();
        new MealDTO(2, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99);
        MealDTO meal = MealDTO.builder()
                .id(1)
                .category(c2)
                .image("/pictures/lasagna.jpg")
                .name("Lasagna")
                .description("tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper")
                .weight(400)
                .price(8.99)
                .build();
        Assertions.assertEquals(meal, moc.GetMeal(1));
    }
    @Test
     void GetCategories() {
        CategoryDTO c2 = CategoryDTO.builder()
                .index(2)
                .name("Pasta")
                .image("./pictures/lasagna.jpg")
                .build();
        Assertions.assertEquals(c2, moc.GetCategories().get(1));
    }
}
