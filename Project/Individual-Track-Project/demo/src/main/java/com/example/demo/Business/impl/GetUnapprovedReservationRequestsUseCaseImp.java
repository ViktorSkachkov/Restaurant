package com.example.demo.Business.impl;

import com.example.demo.Business.GetUnapprovedReservationRequestsUseCase;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.dto.ReservationRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class GetUnapprovedReservationRequestsUseCaseImp implements GetUnapprovedReservationRequestsUseCase {
    private ReservationRepository rdh = new ReservationRepository();
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
