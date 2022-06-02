package com.example.demo.Business.impl;

import com.example.demo.Business.DeleteCartItemUseCart;
import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteCartItemUseCaseImp implements DeleteCartItemUseCart {
    private final CartItemRepository cartItemRepository;
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @Override
    @Transactional
    public CartItem deleteCartItem(long id) {
        CartItem cartItem = cartItemRepository.findById(id);
        List<Adding_Cart_Relation> adding_cart_relations = new ArrayList<>();
                for(Adding_Cart_Relation adding_Cart_Relation : adding_Cart_RelationRepository.findAll())
                {
                    if(adding_Cart_Relation.getCartItem().getId() == id) {
                        adding_cart_relations.add(adding_Cart_Relation);
                    }
                }
                for(Adding_Cart_Relation adding_Cart_Relation : adding_cart_relations) {
                    adding_Cart_RelationRepository.delete(adding_Cart_Relation);
                }
         cartItemRepository.delete(cartItem);
                return cartItem;
    }
}
