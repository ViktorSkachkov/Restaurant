package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.dto.*;

public class AddingCartRelationDTOConverter {
    private AddingCartRelationDTOConverter() {

    }
    public static AddingCartRelationDTO convertToDTO(Adding_Cart_Relation addingCartRelation) {
        UserDTO userDTO = UserDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getCartItem().getUser().getId()))
                .firstName(addingCartRelation.getCartItem().getUser().getFirstName())
                .lastName(addingCartRelation.getCartItem().getUser().getLastName())
                .username(addingCartRelation.getCartItem().getUser().getUsername())
                .pwd(addingCartRelation.getCartItem().getUser().getPwd())
                .email(addingCartRelation.getCartItem().getUser().getEmail())
                .address(addingCartRelation.getCartItem().getUser().getAddress())
                .phone(addingCartRelation.getCartItem().getUser().getPhone())
                .logged(false)
                .category(addingCartRelation.getCartItem().getUser().getCategory())
                .build();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getCartItem().getMeal().getCategory().getId()))
                .name(addingCartRelation.getCartItem().getMeal().getCategory().getName())
                .image(addingCartRelation.getCartItem().getMeal().getCategory().getImage())
                .build();
        MealDTO mealDTO = MealDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getCartItem().getMeal().getId()))
                .category(categoryDTO)
                .image(addingCartRelation.getCartItem().getMeal().getImage().toString())
                .name(addingCartRelation.getCartItem().getMeal().getName())
                .description(addingCartRelation.getCartItem().getMeal().getDescription())
                .weight(addingCartRelation.getCartItem().getMeal().getWeight())
                .price(addingCartRelation.getCartItem().getMeal().getPrice())
                .build();
        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getCartItem().getId()))
                .user(userDTO)
                .meal(mealDTO)
                .numberOfItems(addingCartRelation.getCartItem().getNumberOfItems())
                .approved(addingCartRelation.getCartItem().getApproved())
                .dateOfOrder(addingCartRelation.getCartItem().getTimeOfOrder())
                .cutlariesNeeded(addingCartRelation.getCartItem().getCutlaries_needed())
                .build();
        AddingDTO addingDTO = AddingDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getAdding().getId()))
                .name(addingCartRelation.getAdding().getName())
                .weight(addingCartRelation.getAdding().getWeight())
                .price(addingCartRelation.getAdding().getPrice())
                .build();
        return AddingCartRelationDTO.builder()
                .id(Math.toIntExact(addingCartRelation.getId()))
                .approved(addingCartRelation.getApproved())
                .adding(addingDTO)
                .cartItem(cartItemDTO)
                .build();
    }
}
