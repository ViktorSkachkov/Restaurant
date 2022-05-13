package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetReservationRequestUseCase;
import com.example.demo.MockRepositories.MockReservationRepository;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

public class MockGetReservationRequestUseCaseImp /*implements GetReservationRequestUseCase*/ {
    private MockReservationRepository rdh = new MockReservationRepository();
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
