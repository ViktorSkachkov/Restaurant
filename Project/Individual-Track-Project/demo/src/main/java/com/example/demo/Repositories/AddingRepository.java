package com.example.demo.Repositories;

import com.example.demo.Normal.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddingRepository extends JpaRepository<Adding, Long> {
    boolean existsById(int id);
}
