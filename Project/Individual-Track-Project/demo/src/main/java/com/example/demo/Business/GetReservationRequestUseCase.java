package com.example.demo.Business;

import com.example.demo.dto.GetReservationRequestResponseDTO;
import com.example.demo.dto.ReservationRequestDTO;

public interface GetReservationRequestUseCase {
    /*public ReservationRequestDTO GetReservationRequest(int reservationID);*/
    GetReservationRequestResponseDTO getReservationRequests();
}
