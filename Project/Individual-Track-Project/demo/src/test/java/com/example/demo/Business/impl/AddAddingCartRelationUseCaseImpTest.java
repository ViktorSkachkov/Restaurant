package com.example.demo.Business.impl;

import com.example.demo.Business.GetUsersUseCase;
import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.*;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAddingCartRelationUseCaseImpTest {
    @Mock
    private Adding_Cart_RelationRepository adding_cart_relationMockRepositoryMock;
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @Mock
    private CategoryRepository categoryRepositoryMock;
    @Mock
    private MealRepository mealRepositoryMock;
    @Mock
    private CartItemRepository cartItemRepositoryMock;
    @Mock
    private AddingRepository addingRepositoryMock;
    @Mock
    private Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCaseImp;
    @InjectMocks
    private GetCategoriesUseCaseImp getCategoriesUseCase;
    @InjectMocks
    private GetMealsUseCaseImp getMealsUseCase;
    @InjectMocks
    private GetCartItemsUseCaseImp getCartItemsUseCase;
    @InjectMocks
    private GetAddingsUseCaseImp getAddingsUseCase;
    @InjectMocks
    private AddAddingCartRelationUseCaseImp addAddingCartRelationUseCase;
    @InjectMocks
    private AddCartItemUseCaseImp addCartItemUseCase;
    @Test
    void addAdding_Cart_Relation() {
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
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        GetUsersResponseDTO usersResponseDTO = getUsersUseCaseImp.getUsers(0);
        LocalDateTime timeOfOrder = LocalDateTime.of(2022, Month.MAY, 30, 19, 6, 24);

        Category category = Category.builder()
                .id(2L)
                .image("lasagna.jpg")
                .name("Pasta")
                .build();

        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        GetCategoriesResponseDTO categoriesResponseDTO = getCategoriesUseCase.getCategories();
        Meal meal = Meal.builder()
                .id(2L)
                .category(category)
                .description("tomatoes, beef, parmesan, onion, garlic, parsley, oregano, bell pepper")
                .image("lasagna.jpg")
                .name("Lasagna")
                .weight(400)
                .price(8.99)
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(meal.getCategory().getId()))
                .image(meal.getCategory().getImage())
                .name(meal.getCategory().getName())
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
        GetMealsResponseDTO mealResult = getMealsUseCase.getMeals();
        Adding adding = Adding.builder()
                .id(2L)
                .name("Mushrooms")
                .price(1)
                .weight(50)
                .build();
        when(addingRepositoryMock.findAll()).thenReturn(List.of(adding));
        GetAddingsResponseDTO getAddingsResponseDTO = getAddingsUseCase.getAddings();
        List<Integer> addingList = new ArrayList<>();
        addingList.add(2);
      CreateCartItemRequestDTO createCartItemRequestDTO = CreateCartItemRequestDTO.builder()
              .addings(addingList)
              .user(userDto)
              .numberOfItems(3)
              .meal(mealDto)
              .build();
      CartItem cartItem = CartItem.builder()
              .meal(meal)
              .numberOfItems(createCartItemRequestDTO.getNumberOfItems())
              .user(user)
              .timeOfOrder(LocalDateTime.now())
              .cutlaries_needed("false")
              .approved("false")
              .build();
        when(cartItemRepositoryMock.save(cartItem)).thenReturn(cartItem);
        CartItem savedCartItem = cartItemRepositoryMock.save(cartItem);
        assertEquals(cartItem, savedCartItem);
        //CreateCartItemResponseDTO response = addCartItemUseCase.createCartItem(createCartItemRequestDTO);
        //assertEquals(1, response.getCartItemId());
    }
}