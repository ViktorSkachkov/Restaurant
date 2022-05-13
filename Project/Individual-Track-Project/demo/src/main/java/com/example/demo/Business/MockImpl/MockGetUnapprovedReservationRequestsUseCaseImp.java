package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetUnapprovedReservationRequestsUseCase;
import com.example.demo.MockRepositories.MockReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetUnapprovedReservationRequestsUseCaseImp implements GetUnapprovedReservationRequestsUseCase {
    private MockReservationRepository rdh = new MockReservationRepository();
    @Override
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> unapprovedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.rdh.GetReservationRequests()) {
            if(!reservationRequest.getApproved().equals("true"))
            {
                unapprovedReservationRequests.add(reservationRequest);
            }
        }
        return unapprovedReservationRequests;
    }
}
