package com.example.demo.Business.impl;

import com.example.demo.Repositories.*;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.TableItemDTO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private ReservationRepository rdh = new ReservationRepository();
    public ReservationService(ReservationRepository reservationDataHelper) {
        this.rdh = reservationDataHelper;
    }
    public ReservationRequestDTO GetReservationRequest(int reservationID)
    {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO t: rdh.GetReservationRequests()) {
            if(t.getId() == reservationID) {
                reservationRequest = t;
                return reservationRequest;
            }
        }
        return null;
    }
    public List<TableItemDTO> GetTables()
    {
        return this.rdh.GetTables();
    }
    public TableItemDTO GetTable(int tableID)
    {
        TableItemDTO table = null;
        for(TableItemDTO t: rdh.GetTables()) {
            if(t.getId() == tableID) {
                table = t;
                return table;
            }
        }
        return null;
    }
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> unapprovedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.rdh.GetReservationRequests()) {
            if(!reservationRequest.getApproved().equals("true"))
            {
                unapprovedReservationRequests.add(reservationRequest);
            }
        }
        return unapprovedReservationRequests;
    }
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> approvedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.rdh.GetReservationRequests()) {

            if(reservationRequest.getApproved().equals("true"))
            {
                approvedReservationRequests.add(reservationRequest);
            }
        }
        return approvedReservationRequests;
    }
}
