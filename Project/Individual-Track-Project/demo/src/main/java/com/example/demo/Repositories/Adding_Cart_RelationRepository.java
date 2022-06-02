package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adding_Cart_RelationRepository extends JpaRepository<Adding_Cart_Relation, Long> {
    boolean existsById(int id);
}
