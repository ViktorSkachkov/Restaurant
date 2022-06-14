package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.configuration.security.auth.AuthenticationRequestFilter;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReservationController.class)
class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetTableItemsUseCase getTableItemsUseCase;
    @MockBean
    private GetReservationRequestUseCase getReservationRequestUseCase;
    @MockBean
    private GetUsersUseCase getUsersUseCase;
    @MockBean
    private DeleteReservationUseCase deleteReservationUseCase;
    @MockBean
    private GetReservationTableRelationsUseCase getReservationTableRelationsUseCase;
    @MockBean
    private AssignTableUseCase assignTableUseCase;
    @MockBean
    private AddReservationRequestUseCase addReservationRequestUseCase;
    @MockBean
    private AuthenticationRequestFilter authenticationRequestFilter;

   /* @Test
    void getTest() throws Exception {
        mockMvc.perform(get("/reservations/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                                  "answer"
                        """));
    }*/

    @Test
    void getSpecificTable() throws Exception {
        GetTableItemsResponseDTO getTableItemsResponseDTO = GetTableItemsResponseDTO.builder()
                .tableItems(List.of(TableItemDTO.builder()
                        .id(1)
                        .location("Inside")
                        .seats(4)
                        .build()))
                .build();
        when(getTableItemsUseCase.getTableItems())
                .thenReturn(getTableItemsResponseDTO);
        mockMvc.perform(get("/reservations/tableItem/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                               {
                                                            "id": 1,
                                                                   "location":  "Inside" ,
                                                            "seats":  4
                                             
                                                        }
                        """));
        verify(getTableItemsUseCase).getTableItems();
    }










    @Test
    void getSpecificTableItem2() throws Exception {
        GetUsersResponseDTO getUsersResponseDTO = GetUsersResponseDTO.builder()
                .users(List.of(UserDTO.builder()
                        .id(1)
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("WORKER")
                        .build()))
                .build();
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        when(getUsersUseCase.getUsers(0))
                .thenReturn(getUsersResponseDTO);
        TableItemDTO tableItemDTO = TableItemDTO.builder()
                .id(1)
                .location("Inside")
                .seats(4)
                .build();
        TableItem tableItem = TableItem.builder()
                .id(1L)
                .location("Inside")
                .seats(4)
                .build();
        GetTableItemsResponseDTO getTableItemsResponseDTO = GetTableItemsResponseDTO.builder()
                .tableItems(List.of(tableItemDTO))
                .build();
        when(getTableItemsUseCase.getTableItems())
                .thenReturn(getTableItemsResponseDTO);
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);
        String formatted_start_time = startTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String formatted_finish_time = finishTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
        .id(1)
        .numberOfPeople(4)
        .formatted_start_time(formatted_start_time)
        .formatted_finish_time(formatted_finish_time)
        .finish_time(finishTime)
        .start_time(startTime)
        .preferences("Inside")
        .approved("false")
        .user(getUsersResponseDTO.getUsers().get(0))
        .build();
        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(1L)
                .numberOfPeople(4)
                .finish_time(finishTime)
                .start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(user)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
Reservation_Table_Relation reservation_table_relation = Reservation_Table_Relation.builder()
        .id(1L)
        .reservationRequest(reservationRequest)
        .table(tableItem)
        .build();
GetReservationTableRelationsResponseDTO getReservationTableRelationsResponseDTO = GetReservationTableRelationsResponseDTO.builder()
        .reservation_table_relationList(List.of(reservation_table_relation))
        .build();
        when(getReservationTableRelationsUseCase.getReservationTableRelations(1))
                .thenReturn(getReservationTableRelationsResponseDTO);

        mockMvc.perform(get("/reservations/tables/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            [ {     "id": 1,
                                                     "location": "Inside",
                                                     "seats": 4}]
                        """));

        verify(getUsersUseCase).getUsers(0);
    }


    @Test
    void deleteReservation() throws Exception {
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
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
                .category("WORKER")
                .build();
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);

        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(1L)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(user)
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
       /* when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);*/

        when(deleteReservationUseCase.deleteReservation(reservationRequest.getId()))
                .thenReturn(reservationRequest);

        mockMvc.perform(get("/reservations/deleteReservation/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             {     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "false",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "user":  {
                                                     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                                     }}
                        """));
    }
    @Test
    void GetUnapprovedReservations() throws Exception {
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
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
                .category("WORKER")
                .build();
        LocalDateTime startTime = LocalDateTime.of(2022, Month.JUNE, 30, 20, 0, 0);
        LocalDateTime finishTime = LocalDateTime.of(2022, Month.JUNE, 30, 22, 0, 0);

        ReservationRequest reservationRequest = ReservationRequest.builder()
                .id(1L)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(user)
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        mockMvc.perform(get("/reservations/unapprovedReservationRequests"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             [{     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "false",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "user":  {
                                                     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                                     }}]
                        """));
    }
    @Test
    void GetApprovedReservations() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("true")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        mockMvc.perform(get("/reservations/approvedReservationRequests"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             [{     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "true",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "user":  {
                                                     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                                     }}]
                        """));
    }
    @Test
    void getAll() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        mockMvc.perform(get("/reservations/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             [{     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "false",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "user":  {
                                                     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                                     }}]
                        """));
    }
    @Test
    void getSpecificReservation() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        mockMvc.perform(get("/reservations/reservationItem/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             {     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "false",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "user":  {
                                                     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"
                                                     }}
                        """));
    }
    @Test
    void CreateReservation() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        CreateReservationRequestRequestDTO c = CreateReservationRequestRequestDTO.builder()
                .clientId(userDTO.getId())
                .finish_time(null)
                .finish_time(null)
                .numberOfPeople(4)
                .preferences("Inside")
                .build();
        CreateReservationRequestResponseDTO createReservationRequestResponseDTO = CreateReservationRequestResponseDTO.builder()
                .reservationRequestId((long) reservationRequestDTO.getId())
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        when(addReservationRequestUseCase.createReservationRequest(c)).thenReturn(createReservationRequestResponseDTO);
        mockMvc.perform(post("/reservations/createReservation"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                             {     "id": 1,
                                                     "numberOfPeople": 4,
                                                     "preferences": "Inside",
                                                     "approved": "false",
                                                     "start_time": "",
                                                     "finish_time": "",
                                                     "clientId": 1
                                                     }
                        """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "reservationRequestId":  1 }
                       """));
    }
    @Test
    void assignTable() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        ReservationRequestDTO reservationRequestDTO = ReservationRequestDTO.builder()
                .id(1)
                .numberOfPeople(4)
                //.finish_time(finishTime)
                //.start_time(startTime)
                .preferences("Inside")
                .approved("false")
                .user(userDTO)
                .build();
        GetReservationRequestResponseDTO getReservationRequestResponseDTO = GetReservationRequestResponseDTO.builder()
                .reservationRequests(List.of(reservationRequestDTO))
                .build();
        when(getReservationRequestUseCase.getReservationRequests())
                .thenReturn(getReservationRequestResponseDTO);
        TableItemDTO tableItemDTO = TableItemDTO.builder()
                .id(1)
                .location("Inside")
                .seats(4)
                .build();
        GetTableItemsResponseDTO getTableItemsResponseDTO = GetTableItemsResponseDTO.builder()
                .tableItems(List.of(tableItemDTO))
                .build();
        when(getTableItemsUseCase.getTableItems())
                .thenReturn(getTableItemsResponseDTO);
        //when(assignTableUseCase.reassignTable(tableItemDTO.getId(), reservationRequestDTO.getId())).thenReturn();
        mockMvc.perform(get("/reservations/assignTable/1/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                           1
                        """));
    }
}