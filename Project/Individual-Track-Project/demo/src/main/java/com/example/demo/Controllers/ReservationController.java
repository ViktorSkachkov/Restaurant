package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final GetTableItemsUseCase getTableItemsUseCase;
    private final GetReservationRequestUseCase getReservationRequestUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final DeleteReservationUseCase deleteReservationUseCase;
    private final GetReservationTableRelationsUseCase getReservationTableRelationsUseCase;
    private final AssignTableUseCase assignTableUseCase;
    private final AddReservationRequestUseCase addReservationRequestUseCase;

   /* @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/test")
    public String test() {
        return "answer";
    }*/

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/all")
    public List<ReservationRequestDTO> GetAll()
    {
        return getReservationRequestUseCase.getReservationRequests().getReservationRequests();
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/reservationItem/{id}")
    public ReservationRequestDTO GetReservationRequest(@PathVariable int id)
    {
        ReservationRequestDTO reservationRequest = null;
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {
            if(rr.getId() == id) {
                reservationRequest = rr;
            }
        }
        return reservationRequest;
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping("/createReservation")
    public CreateReservationRequestResponseDTO createReservationRequest(@RequestBody @Valid CreateReservationRequestRequestDTO createReservationRequestRequestDTO) {
        return addReservationRequestUseCase.createReservationRequest(createReservationRequestRequestDTO);
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/assignTable/{tableId}/{reservationId}")
    public int AssignTable(@PathVariable(value = "tableId") final long tableId,
                            @PathVariable(value = "reservationId") final long reservationId)
    {
        assignTableUseCase.reassignTable(tableId, reservationId);
        return (int) reservationId;
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/tables/{id}")
    public List<TableItemDTO> getTableItems(@PathVariable(value = "id") final long id)
    {
      int index = 0;
        for(Reservation_Table_Relation rr : getReservationTableRelationsUseCase.getReservationTableRelations((int) id).getReservation_table_relationList()) {
            if(rr.getReservationRequest().getId() == id) {
               index = Math.toIntExact(rr.getTable().getId());
            }
        }
        List<TableItemDTO> tableItemDTOS = new ArrayList<>();
        for(TableItemDTO tableItemDTO :getTableItemsUseCase.getTableItems().getTableItems()) {
            if(tableItemDTO.getId() != 0/*index*/) {
                tableItemDTOS.add(tableItemDTO);
            }
        }
        return tableItemDTOS;

    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/relations/{id}")
    public TableItem getRelation(@PathVariable(value = "id") final long id ) {
        Reservation_Table_Relation reservation_table_relation = null;
        for(Reservation_Table_Relation rr : getReservationTableRelationsUseCase.getReservationTableRelations((int) id).getReservation_table_relationList()) {
            if(rr.getReservationRequest().getId() == id) {
                reservation_table_relation = rr;
            }
        }
        return reservation_table_relation.getTable();
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/tableItem/{id}")
    public TableItemDTO GetTable(@PathVariable(value = "id") final int id)
    {
       TableItemDTO table = null;
       GetTableItemsResponseDTO getTableItemsResponseDTO = getTableItemsUseCase.getTableItems();
        for(TableItemDTO rr : getTableItemsResponseDTO.getTableItems()) {
            if(rr.getId() == id) {
                table = rr;
            }
        }
        return table;
        /*TableItemDTO tableItemDTO = TableItemDTO.builder()
                .id(1)
                .location("Inside")
                .seats(4)
                .build();
        return  tableItemDTO;*/
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/deleteReservation/{id}")
    public ReservationRequest deleteReservation(@PathVariable(value = "id") final long id) {
        return deleteReservationUseCase.deleteReservation(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/unapprovedReservationRequests")
    public List<ReservationRequestDTO> GetUnapprovedReservationRequests() {
        List<ReservationRequestDTO> reservationRequestList = new ArrayList<>();
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {

            if(rr.getApproved().equals("false")) {
                reservationRequestList.add(rr);
            }
        }
        return reservationRequestList;
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/approvedReservationRequests")
    public List<ReservationRequestDTO> GetApprovedReservationRequests() {
        List<ReservationRequestDTO> reservationRequestList = new ArrayList<>();
        for(ReservationRequestDTO rr : getReservationRequestUseCase.getReservationRequests().getReservationRequests()) {

            if(rr.getApproved().equals("true")) {
                reservationRequestList.add(rr);
            }
        }
        return reservationRequestList;
    }
}
