package com.example.demo.Controllers;

import com.example.demo.Administrations.*;
import com.example.demo.MockAdministration.*;
import com.example.demo.Normal.ReservationRequest;
import com.example.demo.Normal.*;

import java.util.ArrayList;
import java.util.*;

public class ReservationController {
    private ReservationAdministration reservationAdministration;
    private MockReservationAdministration mockReservationAdministration;
    private List<Table> tables;
    private List<ReservationRequest> reservationRequests;
    public ReservationController(ReservationAdministration reservationAdministration) {
        this.reservationAdministration = reservationAdministration;
    }
    public ReservationController(MockReservationAdministration mockReservationAdministration) {
        this.mockReservationAdministration = mockReservationAdministration;
    }
    public ReservationRequest GetReservationRequest(int id) {
        return null;
    }
    public List<Table> GetTables() {
        return this.tables;
    }
    public List<ReservationRequest> GetUnapprovedReservationRequests() {
        List<ReservationRequest> unapprovedReservationRequests = new ArrayList<>();
        for(ReservationRequest reservationRequest : this.reservationRequests) {
            if(!reservationRequest.getApproved())
            {
                unapprovedReservationRequests.add(reservationRequest);
            }
        }
        return unapprovedReservationRequests;
    }
    public List<ReservationRequest> GetApprovedReservationRequests() {
        List<ReservationRequest> approvedReservationRequests = new ArrayList<>();
        for(ReservationRequest reservationRequest : this.reservationRequests) {
            if(reservationRequest.getApproved())
            {
                approvedReservationRequests.add(reservationRequest);
            }
        }
        return approvedReservationRequests;
    }
}
