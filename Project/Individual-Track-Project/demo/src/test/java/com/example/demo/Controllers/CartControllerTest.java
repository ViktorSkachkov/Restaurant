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

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CartController.class)
class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetOrderedMealsUseCase getOrderedMealsUseCase;
    @MockBean
    private GetOrderItemsUseCase getOrderItemsUseCase;
    @MockBean
    private GetUsersUseCase getUsersUseCase;
    @MockBean
    private GetCartItemsUseCase getCartItemsUseCase;
    @MockBean
    private GetAddingCartRelationsUseCase getAddingCartRelationsUseCase;
    @MockBean
    private DeleteCartItemUseCart deleteCartItemUseCart;
    @MockBean
    private IncreaseNumberOfItemsUseCase increaseNumberOfItemsUseCase;
    @MockBean
    private DecreaseNumberOfItemsUseCase decreaseNumberOfItemsUseCase;
    @MockBean
    private AccessTokenDecoder accessTokenDecoder;
    @Test
    void getAddingCartRelationList() throws Exception{
        GetUsersResponseDTO getUsersResponseDTO = GetUsersResponseDTO.builder()
                .users(List.of(UserDTO.builder()
                        .id(1)
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("WORKER")
                        .build()))
                .build();
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
        TableItemDTO tableItemDTO = TableItemDTO.builder()
                .id(1)
                .location("Inside")
                .seats(4)
                .build();
        GetTableItemsResponseDTO getTableItemsResponseDTO = GetTableItemsResponseDTO.builder()
                .tableItems(List.of(tableItemDTO))
                .build();
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);
        String formatted_start_time = startTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String formatted_finish_time = finishTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                .formatted_start_time(formatted_start_time)
                .formatted_finish_time(formatted_finish_time)
                .finish_time(finishTime)
                .start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(getUsersResponseDTO.getUsers().get(0))
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
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
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
        Adding adding = Adding.builder()
                .id(2L)
                .name("Mushrooms")
                .price(1)
                .weight(50)
                .build();
        Adding_Cart_Relation adding_cart_relation = Adding_Cart_Relation.builder()
                .id(1L)
                .approved("false")
                .cartItem(cartItem)
                .adding(adding)
                .build();
        GetAddingCartRelationResponseDTO getAddingCartRelationResponseDTO = GetAddingCartRelationResponseDTO.builder()
                .addingDTOList(List.of(adding_cart_relation))
                .build();
        when(getAddingCartRelationsUseCase.getAddingCartRelations())
                .thenReturn(getAddingCartRelationResponseDTO);
        mockMvc.perform(get("/cart/specificAddings/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            [ {     "id": 1,
                                                     "approved":  "false",
                                                     "cartItem":  {    
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
                                                     "approved": "false"},
                                                     "adding":  {
                                                         "id": 2,
                                                                     "name": "Mushrooms",
                                                                     "price": 1,
                                                                     "weight": 50
                                                     }}]
                        """));
        verify(getAddingCartRelationsUseCase).getAddingCartRelations();
    }
    @Test
    void getListOfNumbers() throws Exception {
        UserDTO user = UserDTO.builder()
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
        CartItemDTO cartItem = CartItemDTO.builder()
                .id(1)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItem))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);
        mockMvc.perform(get("/cart/listOfNumbers/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
            [4]
    """));
        verify(getCartItemsUseCase).getCartItems();
    }
    @Test
    void getAllCartItems() throws Exception {
        UserDTO user = UserDTO.builder()
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
        CartItemDTO cartItem = CartItemDTO.builder()
                .id(1)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItem))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);
        mockMvc.perform(get("/cart/cartItems"))
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
                                                     "cutlariesNeeded": "false",
                                                     "approved": "false"} ]
        """));
        verify(getCartItemsUseCase).getCartItems();
    }
    @Test
    void getSpecificCartItems() throws Exception {
        UserDTO user = UserDTO.builder()
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
        CartItemDTO cartItem = CartItemDTO.builder()
                .id(1)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .cutlariesNeeded("false")
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItem))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);
        mockMvc.perform(get("/cart/specificCartItems/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
             
                                              [      {    
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
                                                     "cutlariesNeeded": "false",
                                                     "approved": "false"} ]
    """));
        verify(getCartItemsUseCase).getCartItems();
    }
    @Test
    void deleteCartItem() throws Exception {
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
        when(deleteCartItemUseCart.deleteCartItem(cartItem.getId()))
                .thenReturn(cartItem);
        mockMvc.perform(get("/cart/deleteCartItem/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
      {    
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
                                                     "approved": "false"} 
     """));
        verify(deleteCartItemUseCart).deleteCartItem(cartItem.getId());
    }
    @Test
    void increaseNumberOfItems() throws Exception {
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
        AddingDTO addingDTO = AddingDTO.builder()
                .id(1)
                .price(5.99)
                .weight(50)
                .name("Garlic")
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                .addings(List.of(addingDTO))
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        CartItem cartItemDTO2 = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(5)
                .user(user)
                .cutlaries_needed("false")
                //.addings(List.of(addingDTO))
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);
       when(increaseNumberOfItemsUseCase.increase((long) cartItemDTO.getId()))
                .thenReturn(cartItemDTO2);
        mockMvc.perform(get("/cart/increase/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                 {    
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
                                                     "numberOfItems": 5,
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
                                                     "approved": "false"} 
     """));
        verify(increaseNumberOfItemsUseCase).increase((long) cartItemDTO.getId());
    }
    @Test
    void decreaseNumberOfItems() throws Exception {
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
        AddingDTO addingDTO = AddingDTO.builder()
                .id(1)
                .price(5.99)
                .weight(50)
                .name("Garlic")
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(1)
                .meal(mealDTO)
                .numberOfItems(4)
                .user(userDTO)
                .cutlariesNeeded("false")
                .addings(List.of(addingDTO))
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        CartItem cartItemDTO2 = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(3)
                .user(user)
                .cutlaries_needed("false")
                //.addings(List.of(addingDTO))
                //.timeOfOrder(LocalDateTime.now())
                .approved("false")
                .build();
        GetCartItemsResponseDTO getCartItemsResponseDTO = GetCartItemsResponseDTO.builder()
                .cartItems(List.of(cartItemDTO))
                .build();
        when(getCartItemsUseCase.getCartItems())
                .thenReturn(getCartItemsResponseDTO);
        when(decreaseNumberOfItemsUseCase.decrease((long) cartItemDTO.getId()))
                .thenReturn(cartItemDTO2);
        mockMvc.perform(get("/cart/decrease/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                 {    
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
                                                     "numberOfItems": 3,
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
                                                     "approved": "false"} 
     """));
        verify(decreaseNumberOfItemsUseCase).decrease((long) cartItemDTO.getId());
    }
}
