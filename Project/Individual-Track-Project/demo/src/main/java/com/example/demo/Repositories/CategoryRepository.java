package com.example.demo.Repositories;

import com.example.demo.Normal.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsById(int id);
}
