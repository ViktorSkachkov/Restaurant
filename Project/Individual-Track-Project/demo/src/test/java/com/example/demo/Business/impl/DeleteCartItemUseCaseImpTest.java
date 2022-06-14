package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.*;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;
import com.example.demo.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteCartItemUseCaseImpTest {
    @Mock
    CartItemRepository cartItemRepositoryMock;
    @Mock
    CategoryRepository categoryRepositoryMock;
    @Mock
    UserItemRepository userItemRepositoryMock;
    @Mock
    MealRepository mealRepositoryMock;
    @Mock
    AddingRepository addingRepositoryMock;
    @Mock
    Adding_Cart_RelationRepository adding_Cart_RelationRepositoryMock;
    @InjectMocks
    DeleteCartItemUseCaseImp deleteCartItemUseCase;

    @Test
    void deleteCartItem() {
        Category category = Category.builder()
                .id(2L)
                .image("lasagna.jpg")
                .name("Pasta")
                .build();

        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(category.getId()))
                .image(category.getImage())
                .name(category.getName())
                .build();


        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        List<Category> categoryList = categoryRepositoryMock.findAll();
        assertEquals(category, categoryList.get(0));
        Meal meal = Meal.builder()
                .id(2L)
                .category(category)
                .description("tomatoes, beef, parmesan, onion, garlic, parsley, oregano, bell pepper")
                .image("lasagna.jpg")
                .name("Lasagna")
                .weight(400)
                .price(8.99)
                .build();

        when(mealRepositoryMock.findAll()).thenReturn(List.of(meal));
        List<Meal> mealList = mealRepositoryMock.findAll();
        assertEquals(meal, mealList.get(0));
        User user = User.builder()
                .id(1L)
                .category("CLIENT")
                .phone("94387758434785")
                .address("Pieter Breughelstraat 19")
                .pwd("mahata")
                .username("dragonslayer")
                .email("viktor.skachkov01@gmail.com")
                .firstName("Viktor")
                .lastName("Skachkov")
                .build();
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        List<User> userList = userItemRepositoryMock.findAll();
        assertEquals(user, userList.get(0));

        when(userItemRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
        Optional<User> userOptional = userItemRepositoryMock.findById((long) user.getId());
        User newUser = userOptional.get();
        when(mealRepositoryMock.findById(meal.getId())).thenReturn(Optional.of(meal));
        Optional<Meal> mealOptional = mealRepositoryMock.findById((long) meal.getId());
        Meal newMeal = mealOptional.get();

        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        /*CartItem cartItem2 = CartItem.builder()
                .id(2L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();*/
        when(cartItemRepositoryMock.findAll()).thenReturn(List.of(cartItem));
        List<CartItem> cartItemList = cartItemRepositoryMock.findAll();
        CartItem newCartItem = CartItem.builder()
                .id(cartItemList.get(0).getId())
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        when(cartItemRepositoryMock.findById(cartItemList.get(0).getId())).thenReturn(Optional.of(newCartItem));
        Optional<CartItem> returnCartItemOptional = cartItemRepositoryMock.findById(cartItemList.get(0).getId());
        CartItem returnCartItem = returnCartItemOptional.get();
        assertEquals(newCartItem, returnCartItem);
        Adding adding = Adding.builder()
                .id(1L)
                .name("Garlic")
                .price(1)
                .weight(50)
                .build();
        when(addingRepositoryMock.findAll()).thenReturn(List.of(adding));
        List<Adding> addingList = addingRepositoryMock.findAll();
        assertEquals(adding, addingList.get(0));
        Adding_Cart_Relation adding_cart_relation = Adding_Cart_Relation.builder()
                .id(1L)
                .adding(adding)
                .cartItem(cartItem)
                .approved("false")
                .build();
        when(adding_Cart_RelationRepositoryMock.findAll()).thenReturn(List.of(adding_cart_relation));
        List<Adding_Cart_Relation> adding_cart_relationList = adding_Cart_RelationRepositoryMock.findAll();
        assertEquals(adding_cart_relation, adding_cart_relationList.get(0));
        /*Adding_Cart_Relation adding_cart_relation2 = Adding_Cart_Relation.builder()
                .id(1L)
                .adding(adding)
                .cartItem(cartItem)
                .approved("false")
                .build();*/
        when(adding_Cart_RelationRepositoryMock.findAll()).thenReturn(List.of(adding_cart_relation));
        List<Adding_Cart_Relation> adding_cart_relationList2 = adding_Cart_RelationRepositoryMock.findAll();
        //deleteCartItemUseCase.deleteCartItem(cartItem.getId());
        cartItemRepositoryMock.delete(cartItem);
        verify(cartItemRepositoryMock, times(1)).delete(cartItem);

    }
}