package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.ReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {
    boolean existsById(String preferences);
}
