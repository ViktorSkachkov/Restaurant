package com.example.demo.Business.impl;

import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCartItemUseCaseImpTest {
    @Mock
    CartItemRepository cartItemRepositoryMock;
    @Mock
    CategoryRepository categoryRepositoryMock;
    @Mock
    UserItemRepository userItemRepositoryMock;
    @Mock
    MealRepository mealRepositoryMock;
    @InjectMocks
    AddCartItemUseCaseImp addCartItemUseCase;

    @Test
    void addCartItem() {
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

        MealDTO mealDto = MealDTO.builder()
                .id(Math.toIntExact(meal.getId()))
                .category(categoryDTO)
                .description(meal.getDescription())
                .image(meal.getImage())
                .name(meal.getName())
                .weight(meal.getWeight())
                .price(meal.getPrice())
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

        UserDTO userDto = UserDTO.builder()
                .id(Math.toIntExact(user.getId()))
                .category(user.getCategory())
                .phone(user.getPhone())
                .address(user.getAddress())
                .pwd(user.getPwd())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        when(userItemRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
        Optional<User> userOptional = userItemRepositoryMock.findById((long) user.getId());
        User newUser = userOptional.get();
        when(mealRepositoryMock.findById(meal.getId())).thenReturn(Optional.of(meal));
        Optional<Meal> mealOptional = mealRepositoryMock.findById((long) meal.getId());
        Meal newMeal = mealOptional.get();

        CartItem cartItem = CartItem.builder()
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        CreateCartItemRequestDTO createCartItemRequestDTO = CreateCartItemRequestDTO.builder()
                .meal(mealDto)
                .numberOfItems(4)
                .user(userDto)
                .build();
        when(cartItemRepositoryMock.save(cartItem)).thenReturn(cartItem);
        CreateCartItemResponseDTO createCartItemResponseDTO = addCartItemUseCase.createCartItem(createCartItemRequestDTO);
    verify(cartItemRepositoryMock).save(cartItem);
    }
}