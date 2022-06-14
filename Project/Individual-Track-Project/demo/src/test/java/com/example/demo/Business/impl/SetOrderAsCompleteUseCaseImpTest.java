package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.RepositoryClasses.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SetOrderAsCompleteUseCaseImpTest {
/*private final CartItemRepository cartItemRepository;
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @Transactional
    @Override
    public void removeOrder(Long userId) {
        for(Adding_Cart_Relation adding_cart_relation : adding_Cart_RelationRepository.findAll()) {
            if(adding_cart_relation.getCartItem().getUser().getId() == userId) {
                adding_Cart_RelationRepository.delete(adding_cart_relation);
            }
        }
        for(CartItem cartItem : cartItemRepository.findAll()) {
            if(cartItem.getUser().getId() == userId) {
                cartItemRepository.delete(cartItem);
            }
        }
    }*/
    @Mock
    UserItemRepository userItemRepositoryMock;
    @Mock
    MealRepository mealRepositoryMock;
    @Mock
    CategoryRepository categoryRepositoryMock;
    @Mock
    Adding_Cart_RelationRepository adding_cart_relationRepositoryMock;
    @Mock
    CartItemRepository cartItemRepositoryMock;
    @InjectMocks
    SetOrderAsCompleteUseCaseImp setOrderAsCompleteUseCase;
    @Test
    void setOrderAsComplete() {
        Category category = Category.builder()
                .id(2L)
                .image("lasagna.jpg")
                .name("Pasta")
                .build();
        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        List<Category> categoryList = categoryRepositoryMock.findAll();

        assertEquals(category, categoryList.get(0));
        Meal meal = Meal.builder()
                .id(1L)
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
        CartItem cartItem = CartItem.builder()
                .id(1L)
                .meal(meal)
                .numberOfItems(4)
                .user(user)
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .approved("false")
                .build();
        when(cartItemRepositoryMock.findAll()).thenReturn(List.of(cartItem));
        List<CartItem> cartItemList = cartItemRepositoryMock.findAll();
        assertEquals(cartItem, cartItemList.get(0));
        setOrderAsCompleteUseCase.removeOrder(user.getId());
        verify(cartItemRepositoryMock, times(1)).delete(cartItem);
    }
}