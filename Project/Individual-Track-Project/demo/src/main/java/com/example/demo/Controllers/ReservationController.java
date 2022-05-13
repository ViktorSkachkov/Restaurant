package com.example.demo.Controllers;

import com.example.demo.Business.GetCategoriesUseCase;
import com.example.demo.Business.GetReservationRequestUseCase;
import com.example.demo.Business.GetTableItemsUseCase;
import com.example.demo.Business.impl.*;
import com.example.demo.MockServices.*;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/reservations/")
@RequiredArgsConstructor
public class ReservationController {
    /*private ReservationService ra = new ReservationService();
    private MockReservationService mockReservationAdministration;
    private GetUnapprovedReservationRequestsUseCaseImp getUnapprovedReservationRequestsUseCaseImp = new GetUnapprovedReservationRequestsUseCaseImp();
    private GetApprovedReservationRequestsUseCaseImp getApprovedReservationRequestsUseCaseImp = new GetApprovedReservationRequestsUseCaseImp();*/

    private final GetTableItemsUseCase getTableItemsUseCase;
    private final GetReservationRequestUseCase getReservationRequestUseCase;
    /*@Autowired
    public ReservationController(ReservationService reservationAdministration, GetTableItemsUseCase getTableItemsUseCase) {

        this.getTableItemsUseCase = getTableItemsUseCase;
    }*/
    @IsAuthenticated
    @GetMapping("all")
    public List<ReservationRequestDTO> GetAll()
    {
        return getReservationRequestUseCase.getReservationRequests().getReservationRequests();
        //return getReservationRequestUseCaseImp.GetReservationRequest(reservationID);
    }
    @IsAuthenticated
    @GetMapping("reservationItem/{reservationID}")
    public ReservationRequestDTO GetReservationRequest(@PathVariable int reservationID)
    {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {
            if(rr.getId() == reservationID) {
                reservationRequest = rr;
            }
        }
        return reservationRequest;
        //return getReservationRequestUseCaseImp.GetReservationRequest(reservationID);
    }
    /*@GetMapping("tables")
    public List<TableItemDTO> GetTables()
    {
        return getTablesUseCaseImp.GetTables();
    }*/
    /*@GetMapping("tables")
    public ResponseEntity<GetTableItemsResponseDTO> getTableItems()
    {
        return ResponseEntity.ok(getTableItemsUseCase.getTableItems());
    }*/
    @IsAuthenticated
    @GetMapping("tables")
    public List<TableItemDTO> getTableItems()
    {
        return getTableItemsUseCase.getTableItems().getTableItems();
    }
    @IsAuthenticated
    @GetMapping("tableItem/{tableID}")
    public TableItemDTO GetTable(@PathVariable int tableID)
    {
       TableItemDTO table = null;
        for(TableItemDTO rr : getTableItemsUseCase.getTableItems().getTableItems()) {
            if(rr.getId() == tableID) {
                table = rr;
            }
        }
        return table;
        //return getTableUseCaseImp.GetTable(tableID);
    }
    @IsAuthenticated
    @GetMapping("unapprovedReservationRequests")
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> reservationRequestList = new ArrayList<>();
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {
            if(rr.getApproved().equals("false")) {
                reservationRequestList.add(rr);
            }
        }
        return reservationRequestList;
        //return getUnapprovedReservationRequestsUseCaseImp.GetUnapprovedReservationRequests();
    }
    @IsAuthenticated
    @GetMapping("approvedReservationRequests")
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> reservationRequestList = new ArrayList<>();
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {
            if(rr.getApproved().equals("true")) {
                reservationRequestList.add(rr);
            }
        }
        return reservationRequestList;
        //return getApprovedReservationRequestsUseCaseImp.GetApprovedReservationRequests();
    }
}
