package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddingRepository extends JpaRepository<Adding, Long> {
    boolean existsById(int id);
}
