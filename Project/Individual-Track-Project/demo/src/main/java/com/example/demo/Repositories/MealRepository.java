package com.example.demo.Repositories;

import com.example.demo.Normal.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    boolean existsById(int id);
}
