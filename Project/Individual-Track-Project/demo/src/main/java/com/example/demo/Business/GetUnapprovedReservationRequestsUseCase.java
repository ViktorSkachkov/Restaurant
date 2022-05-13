package com.example.demo.Business;

import com.example.demo.dto.ReservationRequestDTO;

import java.util.List;

public interface GetUnapprovedReservationRequestsUseCase {
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests();
}
