package com.example.demo.Business.impl;

import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.Reservation_Table_RelationRepository;
import com.example.demo.Repositories.TableItemRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.GetReservationTableRelationsResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetReservationTableRelationsUseCaseImpTest {
    @Mock
    private ReservationRequestRepository reservationRequestRepositoryMock;
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @Mock
    private TableItemRepository tableItemRepository;
    @Mock
    private Reservation_Table_RelationRepository reservation_Table_RelationRepository;
    @InjectMocks
    private GetReservationTableRelationsUseCaseImp getReservationTableRelationsUseCase;
    @Test
    void getReservationTableRelations() {
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
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        List<User> userList = userItemRepositoryMock.findAll();
        assertEquals(user, userList.get(0));
        TableItem tableItem = TableItem.builder()
                .id(1L)
                .location("Outside")
                .seats(4)
                .build();
        when(tableItemRepository.findAll()).thenReturn(List.of(tableItem));
        List<TableItem> tableItemList = tableItemRepository.findAll();
        assertEquals(tableItem, tableItemList.get(0));
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
        List<ReservationRequest> reservationRequestList = reservationRequestRepositoryMock.findAll();
        assertEquals(reservationRequest, reservationRequestList.get(0));
        Reservation_Table_Relation reservation_table_relation = Reservation_Table_Relation.builder()
                .id(1L)
                .table(tableItem)
                .reservationRequest(reservationRequest)
                .build();

        when(reservation_Table_RelationRepository.findAll()).thenReturn(List.of(reservation_table_relation));
        GetReservationTableRelationsResponseDTO getReservationTableRelationsResponseDTO = getReservationTableRelationsUseCase.getReservationTableRelations(2);
        assertEquals(reservation_table_relation, getReservationTableRelationsResponseDTO.getReservation_table_relationList().get(0));
        verify(reservation_Table_RelationRepository).findAll();
    }
}