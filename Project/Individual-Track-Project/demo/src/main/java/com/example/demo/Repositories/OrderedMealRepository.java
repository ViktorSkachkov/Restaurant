package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.OrderedMeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedMealRepository extends JpaRepository<OrderedMeal, Integer> {

 boolean existsById(Integer index);
}
