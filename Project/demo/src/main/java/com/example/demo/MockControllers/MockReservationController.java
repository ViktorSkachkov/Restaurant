package com.example.demo.MockControllers;

import com.example.demo.MockAdministration.MockReservationAdministration;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("mockReservations/")
public class MockReservationController {
    private MockReservationAdministration mockReservationAdministration;
    private List<TableItemDTO> tables = new ArrayList<>();
    private List<ReservationRequestDTO> reservationRequests = new ArrayList<>();
    ClientDTO client1 = new ClientDTO(1,"Viktor","Skachkov", "dragonslayer",
            "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785");
    ClientDTO client2 = new ClientDTO(2,"Pavel","dimitrov", "bomber",
            "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745");
    @Autowired
    public MockReservationController(MockReservationAdministration mockReservationAdministration) {
        this.mockReservationAdministration = mockReservationAdministration;
        tables.add(new TableItemDTO(1,4,"Outside"));
        tables.add(new TableItemDTO(2,4,"Outside"));
        tables.add(new TableItemDTO(3,2,"Outside"));
        tables.add(new TableItemDTO(4,2,"Outside"));
        tables.add(new TableItemDTO(5,2,"Inside"));
        tables.add(new TableItemDTO(6,2,"Inside"));
        tables.add(new TableItemDTO(7,4,"Inside"));
        tables.add(new TableItemDTO(8,4,"Inside"));
        tables.add(new TableItemDTO(9,2,"Inside"));
        tables.add(new TableItemDTO(10,2,"Inside"));
        reservationRequests.add(new ReservationRequestDTO(1, client1, null,
                "I would like to be outside", 3, 16, false));
        reservationRequests.add(new ReservationRequestDTO(2, client1, null,
                "I would like to be inside", 2, 19, false));
        reservationRequests.add(new ReservationRequestDTO(3, client2, null,
                "I would like to be outside", 4, 14, false));
        reservationRequests.add(new ReservationRequestDTO(4, client2, null,
                "I would like to be inside", 1, 20, true));
    }
    @GetMapping("{reservationID}")
    public ReservationRequestDTO GetReservationRequest(@PathVariable int reservationID)
    {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO t: reservationRequests) {
            if(t.getId() == reservationID) {
                reservationRequest = t;
                return reservationRequest;
            }
        }
        return null;
    }
    @GetMapping("tables")
    public List<TableItemDTO> GetTables()
    {
        return this.tables;
    }
    @GetMapping("{tableID}")
    public TableItemDTO GetTable(@PathVariable int tableID)
    {
        TableItemDTO table = null;
        for(TableItemDTO t: tables) {
            if(t.getId() == tableID) {
                table = t;
                return table;
            }
        }
        return null;
    }
    @GetMapping("unapprovedReservationRequests")
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> unapprovedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.reservationRequests) {
            if(!reservationRequest.getApproved())
            {
                unapprovedReservationRequests.add(reservationRequest);
            }
        }
        return unapprovedReservationRequests;
    }
    @GetMapping("approvedReservationRequests")
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> approvedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.reservationRequests) {
            if(reservationRequest.getApproved())
            {
                approvedReservationRequests.add(reservationRequest);
            }
        }
        return approvedReservationRequests;
    }
}
