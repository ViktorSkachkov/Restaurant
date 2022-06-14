package com.example.demo.Business.impl;

import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.GetReservationRequestResponseDTO;
import com.example.demo.dto.GetUsersResponseDTO;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.Business.impl.*;
import com.example.demo.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetReservationRequestsUseCaseImpTest {
    @Mock
    private ReservationRequestRepository reservationRequestRepositoryMock;

    @Mock
    private UserItemRepository userItemRepositoryRepositoryMock;

   @InjectMocks
   private GetReservationRequestsUseCaseImp getReservationsRequestsUseCase;

    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCase;

    @Test
    void getReservationItems() {
       /* Optional<User> userOptional = userItemRepositoryRepositoryMock.findById(2L);
        User user = userOptional.get();*/
        User user = User.builder()
                .id(2L)
                .firstName("Pavel")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("CLIENT")
                .build();
        when(userItemRepositoryRepositoryMock.findAll()).thenReturn(List.of(user));
        GetUsersResponseDTO getUsersResponseDTO = getUsersUseCase.getUsers(0);


        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(2L)
                .approved("true")
                .user(user)
                .finish_time(finishTime)
                .start_time(startTime)
                .numberOfPeople(6)
                .preferences("Inside")
                .build();
        when(reservationRequestRepositoryMock.findAll()).thenReturn(List.of(reservationRequest));
        GetReservationRequestResponseDTO actualResult = getReservationsRequestsUseCase.getReservationRequests();


        UserDTO userDTO = UserDTO.builder()
                .id(Math.toIntExact(user.getId()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .pwd(user.getPwd())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .logged(false)
                .category(user.getCategory())
                .build();
        String formatted_start_time = reservationRequest.getStart_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String formatted_finish_time = reservationRequest.getFinish_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(2)
                .approved("true")
                .user(userDTO)
                .finish_time(finishTime)
                .start_time(startTime)
                .formatted_finish_time(formatted_finish_time)
                .formatted_start_time(formatted_start_time)
                .numberOfPeople(6)
                .preferences("Inside")
                .build();
        GetReservationRequestResponseDTO expectedResult = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        //assertEquals("Inside", "Inside");
                assertEquals(actualResult, expectedResult);
        verify(reservationRequestRepositoryMock).findAll();
    }
}