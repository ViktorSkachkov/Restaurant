package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adding_Order_RelationRepository extends JpaRepository<Adding_Order_Relation, Long> {
    boolean existsById(int id);
}
