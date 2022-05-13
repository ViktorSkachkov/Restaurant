package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetApprovedReservationRequestsUseCase;
import com.example.demo.MockRepositories.MockReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetApprovedReservationRequestsUseCaseImp implements GetApprovedReservationRequestsUseCase {
    private MockReservationRepository rdh = new MockReservationRepository();
    @Override
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> approvedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.rdh.GetReservationRequests()) {

            if(reservationRequest.getApproved().equals("true"))
            {
                approvedReservationRequests.add(reservationRequest);
            }
        }
        return approvedReservationRequests;
    }
}
