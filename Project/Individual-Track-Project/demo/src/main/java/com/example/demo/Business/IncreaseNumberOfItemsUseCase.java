package com.example.demo.Business;

import com.example.demo.RepositoryClasses.CartItem;

public interface IncreaseNumberOfItemsUseCase {
    CartItem increase(Long id);
}
