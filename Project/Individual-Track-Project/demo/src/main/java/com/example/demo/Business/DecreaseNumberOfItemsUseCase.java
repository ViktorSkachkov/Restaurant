package com.example.demo.Business;

import com.example.demo.RepositoryClasses.CartItem;

public interface DecreaseNumberOfItemsUseCase {
    CartItem decrease(Long id);
}
