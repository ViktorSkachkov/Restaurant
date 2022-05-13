package com.example.demo.Business.impl;

import com.example.demo.Business.GetReservationRequestUseCase;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

public class GetReservationRequestUseCaseImp /*implements GetReservationRequestUseCase*/ {
    private ReservationRepository rdh = new ReservationRepository();
   /* @Override*/
    public ReservationRequestDTO GetReservationRequest(int reservationID) {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO t: rdh.GetReservationRequests()) {
            if(t.getId() == reservationID) {
                reservationRequest = t;
                return reservationRequest;
            }
        }
        return null;
    }
}
