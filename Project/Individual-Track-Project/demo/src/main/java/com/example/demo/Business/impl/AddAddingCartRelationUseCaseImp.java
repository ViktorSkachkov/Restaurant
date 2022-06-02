package com.example.demo.Business.impl;

import com.example.demo.Business.AddAddingCartRelationUseCase;
import com.example.demo.Repositories.AddingRepository;
import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.dto.CreateCartItemResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddAddingCartRelationUseCaseImp implements AddAddingCartRelationUseCase {
    private final CartItemRepository cartItemRepository;
    private final AddingRepository addingRepository;
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @Override
    public void createAddingCartRelation(List<Integer> addings, CreateCartItemResponseDTO createCartItemResponseDTO) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(createCartItemResponseDTO.getCartItemId());
        CartItem cartItem = cartItemOptional.get();
        for(int addingId : addings) {
            Optional<Adding> addingOptional = addingRepository.findById((long) addingId);
            Adding adding = addingOptional.get();
            Adding_Cart_Relation adding_cart_relation = Adding_Cart_Relation.builder()
                    .cartItem(cartItem)
                    .adding(adding)
                    .approved("false")
                    .build();
            adding_Cart_RelationRepository.save(adding_cart_relation);
        }
    }
}
