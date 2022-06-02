package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reservation_Table_RelationRepository extends JpaRepository<Reservation_Table_Relation, Long> {
    boolean existsById(int id);
}
