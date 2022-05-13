package com.example.demo.Repositories;

import com.example.demo.Normal.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Order, Integer> {

    boolean existsById(Integer id);
}
