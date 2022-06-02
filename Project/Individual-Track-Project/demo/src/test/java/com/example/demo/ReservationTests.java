package com.example.demo;


import com.example.demo.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/*
@SpringBootTest
public class ReservationTests {
    MockReservationRepository mrdh = new MockReservationRepository();
    MockGetReservationRequestUseCaseImp mockGetReservationRequestUseCaseImp = new MockGetReservationRequestUseCaseImp();
    @Test
     void GetReservationRequest()
    {
       UserDTO client = ClientDTO.builder()
               .id(1)
               .firstName("Viktor")
               .lastName("Skachkov")
               .username("dragonslayer")
               .password("mahata")
               .email("viktor.skachkov01@gmail.com")
               .address("Pieter Breughelstraat 19")
               .phone("94387758434785")
               .build();
        ReservationRequestDTO reservationRequest = ReservationRequestDTO.builder()
                .id(1)
                .client(client)
                .date(null)
                .preferences("I would like to be outside")
                .numberOfPeople(3)
                .hour(16)
                .approved(false)
                .build();
        Assertions.assertEquals(reservationRequest, mockGetReservationRequestUseCaseImp.GetReservationRequest(1));
    }
    MockGetTablesUseCaseImp mockGetTablesUseCaseImp = new MockGetTablesUseCaseImp();
    @Test
     void GetTables()
    {
        TableItemDTO table = TableItemDTO.builder()
                .id(2)
                .seats(4)
                .location("Outside")
                        .build();
        Assertions.assertEquals(table, mockGetTablesUseCaseImp.GetTables().get(1));
    }
    MockGetTableUseCaseImp mockGetTableUseCaseImp = new MockGetTableUseCaseImp();
    @Test
     void GetTable()
    {
        TableItemDTO table = TableItemDTO.builder()
                .id(1)
                .seats(4)
                .location("Outside")
                .build();
        Assertions.assertEquals(table, mockGetTableUseCaseImp.GetTable(1));
    }
    MockGetUnapprovedReservationRequestsUseCaseImp mockGetUnapprovedReservationRequestsUseCaseImp = new MockGetUnapprovedReservationRequestsUseCaseImp();
    @Test
     void GetUnapprovedReservationRequests() {

        UserDTO client1 = ClientDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .password("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .build();
        ReservationRequestDTO reservationRequest = ReservationRequestDTO.builder()
                .id(2)
                .client(client1)
                .date(null)
                .preferences("I would like to be inside")
                .numberOfPeople(2)
                .hour(19)
                .approved(false)
                        .build();
        Assertions.assertEquals(reservationRequest, mockGetUnapprovedReservationRequestsUseCaseImp.GetUnapprovedReservationRequests().get(1));
    }
    MockGetApprovedReservationRequestsUseCaseImp mockGetApprovedReservationRequestsUseCaseImp = new MockGetApprovedReservationRequestsUseCaseImp();
    @Test
     void GetApprovedReservationRequests() {
        UserDTO client2 = ClientDTO.builder()
                .id(2)
                .firstName("Pavel")
                .lastName("dimitrov")
                .username("bomber")
                .password("Jackal")
                .email("pavel.dimitrov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("43554373753745")
                .build();
        ReservationRequestDTO reservationRequest = ReservationRequestDTO.builder()
                .id(4)
                .client(client2)
                .date(null)
                .preferences("I would like to be inside")
                .numberOfPeople(1)
                .hour(20)
                .approved(true)
                .build();
        Assertions.assertEquals(reservationRequest, mockGetApprovedReservationRequestsUseCaseImp.GetApprovedReservationRequests().get(0));
    }
}
*/