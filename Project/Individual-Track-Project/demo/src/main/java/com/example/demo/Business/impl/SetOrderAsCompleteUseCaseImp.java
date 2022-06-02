package com.example.demo.Business.impl;

import com.example.demo.Business.SetOrderAsCompleteUseCase;
import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SetOrderAsCompleteUseCaseImp implements SetOrderAsCompleteUseCase {
    private final CartItemRepository cartItemRepository;
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
    }
}
