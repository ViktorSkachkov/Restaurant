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
    private final OrderItemRepository orderItemRepository;
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    private final Adding_Order_RelationRepository adding_Order_RelationRepository;
    private final AddingRepository addingRepository;
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
                //List<Order> orderList = new ArrayList<>();
       /* List<Long> cartItemsIds = new ArrayList<>();
                for(CartItem cartItem : cartItems)
                {
                    cartItemsIds.add(cartItem.getId());
                    Order order = Order.builder()
                            .user(cartItem.getUser())
                            .meal(cartItem.getMeal())
                            .numberOfItems(cartItem.getNumberOfItems())
                            .timeOfOrder(LocalDateTime.now())
                            .build();
                    orderList.add(order);
                }
                List<Order> addedOrdersList = new ArrayList<>();
                for(Order order : orderList) {
                    Order addedOrder = orderItemRepository.save(order);
                    addedOrdersList.add(addedOrder);
                }



                for(Adding_Cart_Relation adding_cart_relation : adding_Cart_RelationRepository.findAll())
                {
                    if(adding_cart_relation.getCartItem().getUser().getId() == userId)
                    {
                        adding_cart_relations.add(adding_cart_relation);
                        //adding_Cart_RelationRepository.delete(adding_cart_relation);
                    }
                }*/

                //for(Adding_Cart_Relation adding_cart_relation : adding_cart_relations)
        /*for(int i = 0; i < adding_cart_relations.size(); i++)
                {
                    Long cartId = adding_cart_relations.get(i).getId();
                    int cartIndex = cartItemsIds.indexOf(cartId);
                    //Long orderId = ordersIds.get(cartIndex);
                    /*Optional<Order> orderOptional = orderItemRepository.findById(orderId);
                    Order order = orderOptional.get();*/
                   /* Order order = addedOrdersList.get(i);
                    Optional<Adding> addingOptional = addingRepository.findById(adding_cart_relation.getAdding().getId());
                    Adding adding = addingOptional.get();
                    Adding_Order_Relation adding_order_relation = Adding_Order_Relation.builder()
                            .order(order)
                            .adding(adding)
                            .build();
                    adding_Order_RelationRepository.save(adding_order_relation);*/
               // }







       /* for(CartItem cartItem : cartItems)
        {
            cartItemRepository.delete(cartItem);
        }
        for(Adding_Cart_Relation adding_cart_relation : adding_cart_relations)
        {
            adding_Cart_RelationRepository.delete(adding_cart_relation);
        }*/
    }
}
