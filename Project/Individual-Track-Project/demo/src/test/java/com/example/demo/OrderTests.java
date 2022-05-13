package com.example.demo;

import com.example.demo.Business.MockImpl.*;
import com.example.demo.MockControllers.MockOrderController;
import com.example.demo.MockServices.MockOrderService;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
/*
@SpringBootTest
public class OrderTests {
    MockOrderRepository modh = new MockOrderRepository();
    MockGetAddingsUseCaseImp mockGetAddingsUseCaseImp = new MockGetAddingsUseCaseImp();
    @Test
     void GetAddings() {
        AddingDTO adding = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .weight(50)
                .price(1)
                .build();
         Assertions.assertEquals(adding, mockGetAddingsUseCaseImp.GetAddings().get(1));
    }
    MockGetMealsUseCaseImp mockGetMealsUseCaseImp = new MockGetMealsUseCaseImp();
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
        Assertions.assertEquals(meal, mockGetMealsUseCaseImp.GetMeals().get(1));
    }
    MockGetDessertsUseCaseImp mockGetDessertsUseCaseImp = new MockGetDessertsUseCaseImp();
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
       Assertions.assertEquals(meal, mockGetDessertsUseCaseImp.GetDesserts().get(1));
    }
    MockGetSaladsUseCaseImp mockGetSaladsUseCaseImp = new MockGetSaladsUseCaseImp();
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
Assertions.assertEquals(meal, mockGetSaladsUseCaseImp.GetSalads().get(1));
    }
    MockGetPastaUseCaseImp mockGetPastaUseCaseImp = new MockGetPastaUseCaseImp();
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
Assertions.assertEquals(meal, mockGetPastaUseCaseImp.GetPasta().get(1));
    }
    MockGetPizzaUseCaseImp mockGetPizzaUseCaseImp = new MockGetPizzaUseCaseImp();
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
        Assertions.assertEquals(meal, mockGetPizzaUseCaseImp.GetPizza().get(1));
    }
    MockGetMealUseCaseImp mockGetMealUseCaseImp = new MockGetMealUseCaseImp();
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
        Assertions.assertEquals(meal, mockGetMealUseCaseImp.GetMeal(1));
    }
    MockGetCategoriesUseCaseImp mockGetCategoriesUseCaseImp = new MockGetCategoriesUseCaseImp();
    @Test
     void GetCategories() {
        CategoryDTO c2 = CategoryDTO.builder()
                .index(2)
                .name("Pasta")
                .image("./pictures/lasagna.jpg")
                .build();
        Assertions.assertEquals(c2, mockGetCategoriesUseCaseImp.GetCategories().get(1));
    }
}*/
