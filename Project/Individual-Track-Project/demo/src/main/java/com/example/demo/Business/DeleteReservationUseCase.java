package com.example.demo.Business;

import com.example.demo.RepositoryClasses.ReservationRequest;

public interface DeleteReservationUseCase {
    ReservationRequest deleteReservation(long id);
}
