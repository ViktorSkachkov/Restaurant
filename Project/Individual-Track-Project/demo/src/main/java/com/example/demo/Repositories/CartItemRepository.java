package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findById(long id);
}