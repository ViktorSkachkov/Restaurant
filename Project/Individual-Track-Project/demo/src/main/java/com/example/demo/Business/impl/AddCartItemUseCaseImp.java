package com.example.demo.Business.impl;

import com.example.demo.Business.AddCartItemUseCase;
import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.CreateCartItemRequestDTO;
import com.example.demo.dto.CreateCartItemResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddCartItemUseCaseImp implements AddCartItemUseCase {
    private final CartItemRepository cartItemRepository;

    private final MealRepository mealRepository;
    private final UserItemRepository userItemRepository;

    @Transactional
    @Override
    public CreateCartItemResponseDTO createCartItem(CreateCartItemRequestDTO request)
    {
       CartItem savedCartItem = saveNewCartItem(request);

       return CreateCartItemResponseDTO.builder()
               .cartItemId(savedCartItem.getId())
               .build();
    }
    public CartItem saveNewCartItem(CreateCartItemRequestDTO request) {

        Optional<User> userOptional = userItemRepository.findById((long) request.getUser().getId());
        User newUser = userOptional.get();
        Optional<Meal> mealOptional = mealRepository.findById((long) request.getMeal().getId());
        Meal newMeal = mealOptional.get();
        CartItem newCartItem = CartItem.builder()
                .meal(newMeal)
                .user(newUser)
                .numberOfItems(request.getNumberOfItems())
                .approved("false")
                .timeOfOrder(LocalDateTime.now())
                .cutlaries_needed("false")
                .build();
        return cartItemRepository.save(newCartItem);
    }
}
