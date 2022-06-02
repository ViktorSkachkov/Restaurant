package com.example.demo.Business;

import com.example.demo.dto.CreateReservationRequestRequestDTO;
import com.example.demo.dto.CreateReservationRequestResponseDTO;

public interface AddReservationRequestUseCase {
    CreateReservationRequestResponseDTO createReservationRequest(CreateReservationRequestRequestDTO createReservationRequestRequestDTO);
}
