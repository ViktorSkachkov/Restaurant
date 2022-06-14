package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.RepositoryClasses.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteReservationUseCaseImpTest {
    @Mock
    UserItemRepository userItemRepositoryMock;
    @Mock
    ReservationRequestRepository reservationRequestRepositoryMock;
    @Mock
    Reservation_Table_RelationRepository reservation_Table_RelationRepositoryMock;
    @Mock
    TableItemRepository tableItemRepositoryMock;
    @InjectMocks
    DeleteReservationUseCaseImp deleteReservationUseCase;

    @Test
    void deleteReservation() {
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
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        List<User> userList = userItemRepositoryMock.findAll();
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(1L)
                .user(user)
                .start_time(startTime)
                .finish_time(finishTime)
                .preferences("Inside")
                .approved("true")
                .numberOfPeople(6)
                .build();
        when(reservationRequestRepositoryMock.findAll()).thenReturn(List.of(reservationRequest));
        List<ReservationRequest> reservationRequestList = reservationRequestRepositoryMock.findAll();
        TableItem tableItem = TableItem.builder()
                .id(1L)
                .seats(4)
                .location("Outside")
                .build();
        when(tableItemRepositoryMock.findAll()).thenReturn(List.of(tableItem));
        List<TableItem> tableItemList = tableItemRepositoryMock.findAll();
        Reservation_Table_Relation reservation_table_relation = Reservation_Table_Relation.builder()
                .id(1L)
                .table(tableItem)
                .reservationRequest(reservationRequest)
                .build();
        when(reservation_Table_RelationRepositoryMock.findAll()).thenReturn(List.of(reservation_table_relation));
        List<Reservation_Table_Relation> reservation_table_relationList = reservation_Table_RelationRepositoryMock.findAll();
        deleteReservationUseCase.deleteReservation(reservationRequest.getId());
        verify(reservationRequestRepositoryMock, times(1)).delete(reservationRequest);
    }
}