package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Order, Long> {

    boolean existsById(Integer id);
}
