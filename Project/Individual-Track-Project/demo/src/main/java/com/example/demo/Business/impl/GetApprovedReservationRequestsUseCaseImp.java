package com.example.demo.Business.impl;

import com.example.demo.Business.GetApprovedReservationRequestsUseCase;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class GetApprovedReservationRequestsUseCaseImp implements GetApprovedReservationRequestsUseCase {
    private ReservationRepository rdh = new ReservationRepository();
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
