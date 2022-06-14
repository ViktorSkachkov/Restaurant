package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.RepositoryClasses.*;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetMealsUseCase getMealsUseCase;
    @MockBean
    private GetCategoriesUseCase getCategoriesUseCase;
    @MockBean
    private GetAddingsUseCase getAddingsUseCase;
    @MockBean
    private AddMealUseCase addMealUseCase;
    @MockBean
    private UpdateMealUseCase updateMealUseCase;
    @MockBean
    private DeleteMealUseCase deleteMealUseCase;
    @MockBean
    private GetOrderItemsUseCase getOrderItemsUseCase;
    @MockBean
    private AddCartItemUseCase addCartItemUseCase;
    @MockBean
    private AddAddingCartRelationUseCase addAddingCartRelationUseCase;
    @MockBean
    private AddOrdersUseCase addOrdersUseCase;
    @MockBean
    private GetCartItemsUseCase getCartItemsUseCase;
    @MockBean
    private GetAddingCartRelationsUseCase getAddingCartRelationsUseCase;
    @MockBean
    private GetAddingCartRelationsDTOUseCase getAddingCartRelationsDTOUseCase;
    @MockBean
    private SetOrderAsCompleteUseCase setOrderAsCompleteUseCase;
    @MockBean
    private AccessTokenDecoder accessTokenDecoder;
    @Test
    void getAddings() throws Exception {
        AddingDTO addingDTO = AddingDTO.builder()
                .id(1)
                .name("Mushrooms")
                .price(1)
                .weight(50)
                .build();
        GetAddingsResponseDTO getAddingsResponseDTO = GetAddingsResponseDTO.builder()
                .addings(List.of(addingDTO))
                .build();
        when(getAddingsUseCase.getAddings())
                .thenReturn(getAddingsResponseDTO);
        mockMvc.perform(get("/orders/Addings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
        [
        {
            "id": 1,
            "name": "Mushrooms",
            "price": 1,
            "weight": 50
        }
        ]
        """));
    }
    @Test
    void addOrders() throws Exception {
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        Category category = Category.builder()
                .id(1L)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        Meal meal = Meal.builder()
                .id(2L)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                //.timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        when(addOrdersUseCase.addOrders(user.getId(), "false")).thenReturn(List.of(cartItem));
        mockMvc.perform(get("/orders/addOrders/1/false"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
          [{
          "id": 1,  
                                                     "meal": {
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pasta",
                                                                                     "image": "lasagna.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99
                                                     },
                                                     "numberOfItems": 4,
                                                     "user": {
                                                            "id": 1,
                                                                     "firstName": "Viktor",
                                                                     "lastName": "Skachkov",
                                                                     "username": "dragonslayer",
                                                                     "pwd": "mahata",
                                                                     "email": "viktor.skachkov01@gmail.com",
                                                                     "address": "Pieter Breughelstraat 19",
                                                                     "phone": "94387758434785",
                                                                    "category": "WORKER"
                                                     },
                                                     "cutlaries_needed": "false",
                                                     "approved": "false"
          }]
          """));
    }
    @Test
    void getAllMeals() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/Meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                [{
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pasta",
                                                                                     "image": "lasagna.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }]
     """));
    }
    @Test
    void getDesserts() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(4)
                .name("Desserts")
                .image("Desserts.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/Desserts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                [{
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 4,
                                                                                     "name": "Desserts",
                                                                                     "image": "Desserts.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }]
     """));
    }
    @Test
    void getPasta() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(2)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/Pasta"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                [{
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 2,
                                                                                     "name": "Pasta",
                                                                                     "image": "lasagna.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }]
     """));
    }

    @Test
    void getSalads() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(3)
                .name("Salads")
                .image("Caesar.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/Salads"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                [{
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 3,
                                                                                     "name": "Salads",
                                                                                     "image": "Caesar.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }]
     """));
    }
    @Test
    void getPizza() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(1)
                .name("Pizza")
                .image("margherita.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/Pizza"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                [{
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }]
     """));
    }
    @Test
    void getSpecificMeal() throws Exception {
        CategoryDTO category = CategoryDTO.builder()
                .id(1)
                .name("Pizza")
                .image("margherita.jpg")
                .build();
        MealDTO meal = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(meal))
                .build();
        when(getMealsUseCase.getMeals())
                .thenReturn(getMealsResponseDTO);
        mockMvc.perform(get("/orders/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                {
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }
     """));
    }
    @Test
    void setOrderAsComplete() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();

        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);

       /* User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        Category category = Category.builder()
                .id(1L)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        Meal meal = Meal.builder()
                .id(2L)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                //.timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();*/

        mockMvc.perform(get("/orders/setAsOrderComplete/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
       {
       "id":1,
       "user":null,
       "meal":null,
       "approved":null,
       "numberOfItems":0,
       "timeOfOrder":null,
       "cutlaries_needed":null
       }
     """));
    }
    @Test
    void getCategories() throws Exception {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        GetCategoriesResponseDTO getCategoriesResponseDTO = GetCategoriesResponseDTO.builder()
                .categories(List.of(categoryDTO))
                .build();
        when(getCategoriesUseCase.getCategories()).thenReturn(getCategoriesResponseDTO);
        mockMvc.perform(get("/orders/Categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
       [{
       "id":1,
       "name": "Pasta",
       "image": "lasagna.jpg"
       }]
     """));
    }
    @Test
    void createMeal() throws Exception {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(mealDTO))
                .build();
        when(getMealsUseCase.getMeals()).thenReturn(getMealsResponseDTO);
        CreateMealRequestDTO createMealRequestDTO = CreateMealRequestDTO.builder()
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO.getName())
                .weight(350)
                .price(7.99)
                .build();
        CreateMealResponseDTO createMealResponseDTO = CreateMealResponseDTO.builder()
                .mealName(mealDTO.getName())
                .build();

        when(addMealUseCase.createMeal(createMealRequestDTO)).thenReturn(createMealResponseDTO);
        mockMvc.perform(post("/orders/createMeal")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("""
                   {
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }
                        """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "mealName":  "Baked Feta Pasta" }
                       """));
    }
    @Test
    void updateMeal() throws Exception {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
                .meals(List.of(mealDTO))
                .build();
        when(getMealsUseCase.getMeals()).thenReturn(getMealsResponseDTO);
        UpdateMealRequestDTO updateMealRequestDTO = UpdateMealRequestDTO.builder()
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO.getName())
                .weight(350)
                .price(7.99)
                .build();
        UpdateMealResponseDTO updateMealResponseDTO = UpdateMealResponseDTO.builder()
                .mealName(mealDTO.getName())
                .build();
        when(updateMealUseCase.updateMeal(updateMealRequestDTO)).thenReturn(updateMealResponseDTO);
        mockMvc.perform(post("/orders/updateMeal")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("""
                   {
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99                               
                }
                        """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "mealName":  "Baked Feta Pasta" }
                       """));
    }
@Test
    void deleteMeal() throws Exception {
    CategoryDTO categoryDTO = CategoryDTO.builder()
            .id(1)
            .name("Pizza")
            .image("margherita.jpg")
            .build();
    MealDTO mealDTO = MealDTO.builder()
            .id(2)
            .image("")
            .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
            .name("Baked Feta Pasta")
            .category(categoryDTO)
            .weight(350)
            .price(7.99)
            .build();
    Category category = Category.builder()
            .id(1L)
            .name("Pizza")
            .image("margherita.jpg")
            .build();
    Meal meal = Meal.builder()
            .id(2L)
            .image("")
            .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
            .name("Baked Feta Pasta")
            .category(category)
            .weight(350)
            .price(7.99)
            .build();
    GetMealsResponseDTO getMealsResponseDTO = GetMealsResponseDTO.builder()
            .meals(List.of(mealDTO))
            .build();
    when(getMealsUseCase.getMeals()).thenReturn(getMealsResponseDTO);

    when(deleteMealUseCase.deleteMeal(meal.getId())).thenReturn(meal);
    mockMvc.perform(get("/orders/deleteMeal/2"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
            .andExpect(content().json("""
       {
       "id": 2,
                   "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99    
       }
     """));
    }
    @Test
    void getOrders() throws Exception {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pizza")
                .image("margherita.jpg")
                .build();

        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("true")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems()).thenReturn(getCartItemsResponseDTO);

        mockMvc.perform(get("/orders/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
      [{    
                                                     "id": 1,  
                                                     "meal": {
                                                        "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pizza",
                                                                                     "image": "margherita.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99
                                                     },
                                                     "numberOfItems": 4,
                                                     "user": {
                                                            "id": 1,
                                                                     "firstName": "Viktor",
                                                                     "lastName": "Skachkov",
                                                                     "username": "dragonslayer",
                                                                     "pwd": "mahata",
                                                                     "email": "viktor.skachkov01@gmail.com",
                                                                     "address": "Pieter Breughelstraat 19",
                                                                     "phone": "94387758434785",
                                                                    "category": "WORKER"
                                                     },
                                                     "cutlariesNeeded": "false",
                                                     "approved": "true"} ]
     """));
    }
    @Test
    void getUsersForOrders() throws Exception {
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pizza")
                .image("margherita.jpg")
                .build();

        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("true")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems()).thenReturn(getCartItemsResponseDTO);

        mockMvc.perform(get("/orders/specificUsers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
      [ {
                                                            "id": 1,
                                                                     "firstName": "Viktor",
                                                                     "lastName": "Skachkov",
                                                                     "username": "dragonslayer",
                                                                     "pwd": "mahata",
                                                                     "email": "viktor.skachkov01@gmail.com",
                                                                     "address": "Pieter Breughelstraat 19",
                                                                     "phone": "94387758434785",
                                                                    "category": "WORKER"
                                                     } ]
     """));
    }
    @Test
    void getAdding_Cart_Relation() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(2)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(categoryDTO)
                .weight(350)
                .price(7.99)
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);



        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        Category category = Category.builder()
                .id(1L)
                .name("Pasta")
                .image("lasagna.jpg")
                .build();
        Meal meal = Meal.builder()
                .id(2L)
                .image("")
                .description("grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil")
                .name("Baked Feta Pasta")
                .category(category)
                .weight(350)
                .price(7.99)
                .build();
        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                //.timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("true")
                .build();

        Adding adding = Adding.builder()
                .id(2L)
                .name("Mushrooms")
                .price(1)
                .weight(50)
                .build();
        AddingDTO addingDTO = AddingDTO.builder()
                .id(2)
                .name("Mushrooms")
                .price(1)
                .weight(50)
                .build();
        GetAddingsResponseDTO getAddingsResponseDTO = GetAddingsResponseDTO.builder()
                .addings(List.of(addingDTO))
                .build();
        when(getAddingsUseCase.getAddings())
                .thenReturn(getAddingsResponseDTO);

        Adding_Cart_Relation adding_cart_relation = Adding_Cart_Relation.builder()
                .id(1L)
                .approved("true")
                .cartItem(cartItem)
                .adding(adding)
                .build();
        GetAddingCartRelationResponseDTO getAddingCartRelationResponseDTO = GetAddingCartRelationResponseDTO.builder()
                .addingDTOList(List.of(adding_cart_relation))
                .build();
        when(getAddingCartRelationsUseCase.getAddingCartRelations())
                .thenReturn(getAddingCartRelationResponseDTO);
        mockMvc.perform(get("/orders/approvedAddings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                           [
                           {
                                "id": 1,
                                "approved": "true",
                                "cartItem": {
                                "id": 1,
                                "meal": {
                                       "id": 2,
                                                                     "image": "",
                                                                     "description": "grape tomatoes, garlic, olive oil, red pepper, thyme, feta, basil",
                                                                     "name": "Baked Feta Pasta",
                                                                     "category": {
                                                                        "id": 1,
                                                                                     "name": "Pasta",
                                                                                     "image": "lasagna.jpg"
                                                                     },
                                                                     "weight": 350,
                                                                     "price": 7.99
                                },
                                "numberOfItems": 4,
                                "user": {
                                "id": 1,
                                "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                },
                                "cutlaries_needed": "false",
                                 "approved": "true"
                                },
                                "adding": {
                                    "id": 2,
                                    "name": "Mushrooms",
                                    "price": 1,
                                    "weight":50
                                }
                           }
                           ]
                        """));
    }
}