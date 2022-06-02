package com.example.demo.Business;

import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Order;

import java.util.List;

public interface AddOrdersUseCase {
    List<CartItem> addOrders(Long userId, String cutlaries);
}
