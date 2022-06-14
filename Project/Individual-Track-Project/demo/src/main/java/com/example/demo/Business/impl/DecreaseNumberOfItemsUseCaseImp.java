package com.example.demo.Business.impl;

import com.example.demo.Business.DecreaseNumberOfItemsUseCase;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.RepositoryClasses.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DecreaseNumberOfItemsUseCaseImp implements DecreaseNumberOfItemsUseCase {
    private final CartItemRepository cartItemRepository;

    @Transactional
    @Override
    public CartItem decrease(Long id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        CartItem cartItem = cartItemOptional.get();
        int number = cartItem.getNumberOfItems() - 1;
        cartItem.setNumberOfItems(number);
        CartItem cartItem1 = cartItemRepository.save(cartItem);
        return cartItem1;
    }
}
