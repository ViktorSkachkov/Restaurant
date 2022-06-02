package com.example.demo.Business.impl;

import com.example.demo.Business.GetReservationRequestUseCase;
import com.example.demo.Repositories.*;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class GetReservationRequestsUseCaseImp implements GetReservationRequestUseCase {
    private final ReservationRequestRepository reservationRequestRepository;

    @Override
    public GetReservationRequestResponseDTO getReservationRequests() {
        List<ReservationRequestDTO> reservationRequests = reservationRequestRepository.findAll()
                .stream()
                .map(ReservationRequestDTOConverter::convertToDTO)
                .toList();

        return GetReservationRequestResponseDTO.builder()
                .reservationRequests(reservationRequests)
                .build();
    }
}
