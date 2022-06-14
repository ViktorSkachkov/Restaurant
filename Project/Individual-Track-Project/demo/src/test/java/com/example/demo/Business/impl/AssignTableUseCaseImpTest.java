package com.example.demo.Business.impl;

import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.Reservation_Table_RelationRepository;
import com.example.demo.Repositories.TableItemRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.GetReservationRequestResponseDTO;
import com.example.demo.dto.GetReservationTableRelationsResponseDTO;
import com.example.demo.dto.GetTableItemsResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssignTableUseCaseImpTest {
    @Mock
    private ReservationRequestRepository reservationRepositoryMock;
    @Mock
    private UserItemRepository userItemRepositoryRepositoryMock;
    @Mock
    private Reservation_Table_RelationRepository reservation_Table_RelationRepositoryMock;
    @Mock
    private TableItemRepository tableItemRepositoryMock;
    @Mock
    private ReservationRequestRepository reservationRequestRepositoryMock;
    @InjectMocks
    private AssignTableUseCaseImp assignTableUseCase;
    @InjectMocks
    private GetTableItemsUseCaseImp getTableItemsUseCase;
    @InjectMocks
    private GetReservationRequestsUseCaseImp getReservationRequestsUseCase;
    @InjectMocks
    private GetReservationTableRelationsUseCaseImp getReservationTableRelationsUseCase;
    @Test
    void assignTable() {
        TableItem tableItem = TableItem.builder()
                .id(1L)
                .location("Inside")
                .seats(4)
                .build();
        when(tableItemRepositoryMock.findAll()).thenReturn(List.of(tableItem));
        List<TableItem> tableItemList = tableItemRepositoryMock.findAll();
        assertEquals(tableItem, tableItemList.get(0));

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
        List<User> userList = userItemRepositoryRepositoryMock.findAll();
        assertEquals(user, userList.get(0));

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

        when(reservationRequestRepositoryMock.findById(reservationRequest.getId())).thenReturn(Optional.of(reservationRequest));
        Optional<ReservationRequest> reservationRequestOptional = reservationRequestRepositoryMock.findById(reservationRequest.getId());
ReservationRequest r = reservationRequestOptional.get();
        Reservation_Table_Relation reservation_table_relation = Reservation_Table_Relation.builder()
                .id(1L)
                .reservationRequest(reservationRequest)
                .table(tableItem)
                .build();
        when(reservation_Table_RelationRepositoryMock.findAll()).thenReturn(List.of(reservation_table_relation));
        List<Reservation_Table_Relation> reservation_table_relationList = reservation_Table_RelationRepositoryMock.findAll();

        when(reservation_Table_RelationRepositoryMock.save(reservation_table_relation)).thenReturn(reservation_table_relation);
        reservation_Table_RelationRepositoryMock.save(reservation_table_relation);
        verify(reservation_Table_RelationRepositoryMock).save(reservation_table_relation);

        when(reservationRepositoryMock.save(reservationRequest)).thenReturn(reservationRequest);
        reservationRepositoryMock.save(reservationRequest);
        verify(reservationRepositoryMock).save(reservationRequest);




















        /*when(tableItemRepositoryMock.findById(tableItem.getId())).thenReturn(Optional.of(tableItem));
        Optional<TableItem> tableItemOptional = tableItemRepositoryMock.findById(tableItem.getId());
TableItem t = tableItemOptional.get();

        when(reservation_Table_RelationRepositoryMock.findById(reservation_table_relation.getId())).thenReturn(Optional.of(reservation_table_relation));
        Optional<Reservation_Table_Relation> reservation_table_relationOptional = reservation_Table_RelationRepositoryMock.findById(reservation_table_relation.getId());
        Reservation_Table_Relation reservationTableRelation = reservation_table_relationOptional.get();

        Reservation_Table_Relation reservation_table_relation1 = reservation_Table_RelationRepositoryMock.save(reservationTableRelation);
        reservationRequest.setApproved("true");
        reservationRepositoryMock.save(reservationRequest);
        assertEquals(reservation_table_relation1, reservation_table_relation1);*/










        /*when(reservation_Table_RelationRepositoryMock.findAll()).thenReturn(List.of(reservation_table_relation));
        List<Reservation_Table_Relation> reservation_table_relationList = reservation_Table_RelationRepositoryMock.findAll();

        when(reservation_Table_RelationRepositoryMock.findById(reservation_table_relation.getId())).thenReturn(Optional.of(reservation_table_relation));
        Optional<Reservation_Table_Relation> reservation_table_relationOptional = reservation_Table_RelationRepositoryMock.findById(reservation_table_relation.getId());

        when(reservation_Table_RelationRepositoryMock.save(reservation_table_relation)).thenReturn(reservation_table_relation);
        Reservation_Table_Relation reservation_table_relation2 = reservation_Table_RelationRepositoryMock.save(reservation_table_relation);

        when(reservationRepositoryMock.save(reservationRequest)).thenReturn(reservationRequest);
        ReservationRequest reservationRequest2 = reservationRepositoryMock.save(reservationRequest);

        when(reservationRepositoryMock.save(reservationRequest)).thenReturn(reservationRequest);*/
        //assignTableUseCase.reassignTable(tableItem.getId(), reservationRequest.getId());
    }
}