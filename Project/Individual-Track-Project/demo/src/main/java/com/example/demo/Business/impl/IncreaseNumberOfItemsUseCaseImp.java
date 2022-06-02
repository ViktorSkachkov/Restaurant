package com.example.demo.Business.impl;

import com.example.demo.Business.IncreaseNumberOfItemsUseCase;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.RepositoryClasses.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncreaseNumberOfItemsUseCaseImp implements IncreaseNumberOfItemsUseCase {
    private final CartItemRepository cartItemRepository;

    @Transactional
    @Override
    public void increase(Long id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        CartItem cartItem = cartItemOptional.get();
        int number = cartItem.getNumberOfItems() + 1;
        cartItem.setNumberOfItems(number);
        cartItemRepository.save(cartItem);
    }
}
