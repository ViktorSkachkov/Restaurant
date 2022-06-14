package com.example.demo.Business.impl;

import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.GetCartItemsResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncreaseNumberOfItemsUseCaseImpTest {
    @Mock
    CartItemRepository cartItemRepository;
    @Mock
    UserItemRepository userItemRepository;
    @Mock
    MealRepository mealRepository;
    @Mock
    CategoryRepository categoryRepository;
    @InjectMocks
    private IncreaseNumberOfItemsUseCaseImp increaseNumberOfItemsUseCase;
    @Test
    void increaseNumber() {
        Category category = Category.builder()
                .id(2L)
                .image("lasagna.jpg")
                .name("Pasta")
                .build();
        when(categoryRepository.findAll()).thenReturn(List.of(category));
        List<Category> categoryList = categoryRepository.findAll();
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
        when(mealRepository.findAll()).thenReturn(List.of(meal));
        List<Meal> mealList = mealRepository.findAll();
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
        when(userItemRepository.findAll()).thenReturn(List.of(user));
        List<User> userList = userItemRepository.findAll();
        assertEquals(user, userList.get(0));
        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        when(cartItemRepository.findAll()).thenReturn(List.of(cartItem));
        List<CartItem> cartItemList = cartItemRepository.findAll();
        when(cartItemRepository.findById(cartItemList.get(0).getId())).thenReturn(Optional.of(cartItem));
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemList.get(0).getId());
        CartItem returnCartItem = cartItemOptional.get();
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
        increaseNumberOfItemsUseCase.increase(cartItemList.get(0).getId());
        when(cartItemRepository.findById(cartItemList.get(0).getId())).thenReturn(Optional.of(cartItem));
        Optional<CartItem> cartItemOptional2 = cartItemRepository.findById(cartItemList.get(0).getId());
        CartItem returnCartItem2 = cartItemOptional2.get();
        assertEquals(5, returnCartItem2.getNumberOfItems());
    }
}