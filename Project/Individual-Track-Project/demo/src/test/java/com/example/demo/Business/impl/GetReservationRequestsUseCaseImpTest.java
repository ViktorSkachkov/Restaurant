package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.dto.GetReservationRequestResponseDTO;
import com.example.demo.dto.ReservationRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetReservationRequestsUseCaseImpTest {
    @Mock
    private ReservationRequestRepository reservationRequestRepositoryMock;

    @InjectMocks
    private GetReservationRequestsUseCaseImp getReservationRequestsUseCase;

    @Test
    void getOrderItems() {
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(1L)
             //   .clientId(1)
                .approved("true")
                .hour(1)
                .numberOfPeople(1)
                .preferences("1")
                .build();
when(reservationRequestRepositoryMock.findAll()).thenReturn(List.of(reservationRequest));
        GetReservationRequestResponseDTO actualResult = getReservationRequestsUseCase.getReservationRequests();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                //.client(1)
                .approved("true")
                .hour(1)
                .numberOfPeople(1)
                .preferences("1")
                .build();
        GetReservationRequestResponseDTO expectedResult = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(reservationRequestRepositoryMock).findAll();
    }
}