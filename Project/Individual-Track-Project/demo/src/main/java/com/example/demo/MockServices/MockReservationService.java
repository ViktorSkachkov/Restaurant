package com.example.demo.MockServices;

import com.example.demo.MockRepositories.*;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.TableItemDTO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockReservationService {
    private MockReservationRepository mrdh = new MockReservationRepository() ;
    public MockReservationService(MockReservationRepository reservationDataHelper) {
        this.mrdh = reservationDataHelper;
    }
    public ReservationRequestDTO GetReservationRequest(int reservationID)
    {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO t: mrdh.GetReservationRequests()) {
            if(t.getId() == reservationID) {
                reservationRequest = t;
                return reservationRequest;
            }
        }
        return null;
    }
    public List<TableItemDTO> GetTables()
    {
        return this.mrdh.GetTables();
    }
    public TableItemDTO GetTable(int tableID)
    {
        TableItemDTO table = null;
        for(TableItemDTO t: mrdh.GetTables()) {
            if(t.getId() == tableID) {
                table = t;
                return table;
            }
        }
        return null;
    }
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> unapprovedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.mrdh.GetReservationRequests()) {
            if(!reservationRequest.getApproved().equals("true"))
            {
                unapprovedReservationRequests.add(reservationRequest);
            }
        }
        return unapprovedReservationRequests;
    }
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> approvedReservationRequests = new ArrayList<>();
        for(ReservationRequestDTO reservationRequest : this.mrdh.GetReservationRequests()) {

            if(reservationRequest.getApproved().equals("true"))
            {
                approvedReservationRequests.add(reservationRequest);
            }
        }
        return approvedReservationRequests;
    }
}
