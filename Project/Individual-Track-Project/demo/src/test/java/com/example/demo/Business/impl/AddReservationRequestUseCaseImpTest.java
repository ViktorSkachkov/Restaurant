package com.example.demo.Business.impl;

import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.CreateReservationRequestRequestDTO;
import com.example.demo.dto.CreateReservationRequestResponseDTO;
import com.example.demo.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class AddReservationRequestUseCaseImpTest {
    @Mock
    ReservationRequestRepository reservationRequestRepositoryMock;
    @Mock
    UserItemRepository userItemRepositoryMock;
    @InjectMocks
    AddReservationRequestUseCaseImp addReservationRequestUseCase;
    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCase;
    @Test
    void addReservation() {
        Long symbol = Long.valueOf(1);
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("CLIENT")
                .build();
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("CLIENT")
                .build();
       /* when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        GetUsersResponseDTO actualResult = getUsersUseCase.getUsers(symbol);*/
        when(userItemRepositoryMock.save(user)).thenReturn(user);
        User userOptional = userItemRepositoryMock.save(user);
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .user(user)
                .start_time(startTime)
                .finish_time(finishTime)
                .preferences("Inside")
                .approved("true")
                .numberOfPeople(6)
                .build();
        CreateReservationRequestRequestDTO createReservationRequestRequestDTO = CreateReservationRequestRequestDTO.builder()
                .preferences(reservationRequest.getPreferences())
                .clientId(user.getId())
                .numberOfPeople(reservationRequest.getNumberOfPeople())
                .start_time(reservationRequest.getStart_time())
                .finish_time(reservationRequest.getFinish_time())
                .build();
        when(reservationRequestRepositoryMock.save(reservationRequest)).thenReturn(reservationRequest);
        ReservationRequest r = reservationRequestRepositoryMock.save(reservationRequest);
        assertEquals(r, reservationRequest);
        //CreateReservationRequestResponseDTO response = addReservationRequestUseCase.createReservationRequest(createReservationRequestRequestDTO);
    }
}