package com.example.demo.Business.impl;

import com.example.demo.Business.AddOrdersUseCase;
import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddOrdersUseCaseImp implements AddOrdersUseCase {
    private final CartItemRepository cartItemRepository;
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @Transactional
    @Override
    public List<CartItem> addOrders(Long userId, String cutlaries) {
        List<CartItem> cartItems = new ArrayList<>();
        List<Adding_Cart_Relation> adding_cart_relations = adding_Cart_RelationRepository.findAll();
                for(CartItem cartItem : cartItemRepository.findAll())
                {
                    if(cartItem.getUser().getId() == userId)
                    {
                        cartItems.add(cartItem);
                        cartItem.setApproved("true");
                        cartItem.setTimeOfOrder(LocalDateTime.now());
                        cartItem.setCutlaries_needed(cutlaries);
                        cartItemRepository.save(cartItem);
                    }
                }
                for(Adding_Cart_Relation adding_cart_relation : adding_Cart_RelationRepository.findAll()) {
                    if(adding_cart_relation.getCartItem().getUser().getId() == userId) {
                        //adding_cart_relations.add(adding_cart_relation);
                        adding_cart_relation.setApproved("true");
                        adding_Cart_RelationRepository.save(adding_cart_relation);
                    }
                }
                return cartItems;
    }
}
