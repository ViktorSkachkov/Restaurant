package com.example.demo.Business.impl;


import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class CartItemDTOConverter {

    public static CartItemDTO convertToDTO(CartItem cartItem) {

        UserDTO userDTO = UserDTO.builder()
                .id(Math.toIntExact(cartItem.getUser().getId()))
                .firstName(cartItem.getUser().getFirstName())
                .lastName(cartItem.getUser().getLastName())
                .username(cartItem.getUser().getUsername())
                .pwd(cartItem.getUser().getPwd())
                .email(cartItem.getUser().getEmail())
                .address(cartItem.getUser().getAddress())
                .phone(cartItem.getUser().getPhone())
                .logged(false)
                .category(cartItem.getUser().getCategory())
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(cartItem.getMeal().getCategory().getId()))
                .name(cartItem.getMeal().getCategory().getName())
                .image(cartItem.getMeal().getCategory().getImage())
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(Math.toIntExact(cartItem.getMeal().getId()))
                .category(categoryDTO)
                .image(cartItem.getMeal().getImage().toString())
                .name(cartItem.getMeal().getName())
                .description(cartItem.getMeal().getDescription())
                .weight(cartItem.getMeal().getWeight())
                .price(cartItem.getMeal().getPrice())
                .build();
        return CartItemDTO.builder()
                .id(Math.toIntExact(cartItem.getId()))
                .user(userDTO)
                .meal(mealDTO)
                .numberOfItems(cartItem.getNumberOfItems())
                .approved(cartItem.getApproved())
                .dateOfOrder(cartItem.getTimeOfOrder())
                .cutlariesNeeded(cartItem.getCutlaries_needed())
                .build();
    }
}
