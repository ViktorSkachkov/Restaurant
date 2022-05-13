package com.example.demo.MockControllers;

import com.example.demo.Business.MockImpl.*;
import com.example.demo.MockServices.MockReservationService;
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
    private MockReservationService mra = new MockReservationService();
    private MockGetReservationRequestUseCaseImp getReservationRequestUseCaseImp = new MockGetReservationRequestUseCaseImp();
    private MockGetTablesUseCaseImp getTablesUseCaseImp = new MockGetTablesUseCaseImp();
    private MockGetTableUseCaseImp getTableUseCaseImp = new MockGetTableUseCaseImp();
    private MockGetUnapprovedReservationRequestsUseCaseImp getUnapprovedReservationRequestsUseCaseImp = new MockGetUnapprovedReservationRequestsUseCaseImp();
    private MockGetApprovedReservationRequestsUseCaseImp getApprovedReservationRequestsUseCaseImp = new MockGetApprovedReservationRequestsUseCaseImp();

    @Autowired
    public MockReservationController(MockReservationService mockReservationAdministration) {
        this.mra = mockReservationAdministration;
    }
    @GetMapping("{reservationID}")
    public ReservationRequestDTO GetReservationRequest(@PathVariable int reservationID)
    {
       return getReservationRequestUseCaseImp.GetReservationRequest(reservationID);
    }
    @GetMapping("tables")
    public List<TableItemDTO> GetTables()
    {
        return this.getTablesUseCaseImp.GetTables();
    }
    @GetMapping("{tableID}")
    public TableItemDTO GetTable(@PathVariable int tableID)
    {
        return getTableUseCaseImp.GetTable(tableID);
    }
    @GetMapping("unapprovedReservationRequests")
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        return getUnapprovedReservationRequestsUseCaseImp.GetUnapprovedReservationRequests();
    }
    @GetMapping("approvedReservationRequests")
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        return getApprovedReservationRequestsUseCaseImp.GetApprovedReservationRequests();
    }
}
