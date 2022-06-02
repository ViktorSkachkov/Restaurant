package com.example.demo.Business.impl;

import com.example.demo.Business.AssignTableUseCase;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.Reservation_Table_RelationRepository;
import com.example.demo.Repositories.TableItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignTableUseCaseImp implements AssignTableUseCase {
    private final ReservationRequestRepository reservationRepository;
    private final Reservation_Table_RelationRepository reservation_Table_RelationRepository;
    private final TableItemRepository tableItemRepository;

    @Transactional
    @Override
    public void reassignTable(long tableId, long reservationId) {
        Optional<ReservationRequest> reservationRequestOptional = reservationRepository.findById(reservationId);
        long index = 0;
        for(Reservation_Table_Relation rr : reservation_Table_RelationRepository.findAll()) {
            if(rr.getReservationRequest().getId() == reservationId) {
                index = rr.getId();
            }
        }
        if(index != 0) {
            Optional<Reservation_Table_Relation> reservation_table_relationOptional = reservation_Table_RelationRepository.findById(index);
            if (reservation_table_relationOptional != null) {
                Reservation_Table_Relation reservation_table_relation = reservation_table_relationOptional.get();
                reservation_Table_RelationRepository.delete(reservation_table_relation);
            }
        }
        ReservationRequest reservationRequest = reservationRequestOptional.get();
        Optional<TableItem> tableItemOptional = tableItemRepository.findById(tableId);
        TableItem tableItem = tableItemOptional.get();
        Reservation_Table_Relation reservation_Table_Relation =  Reservation_Table_Relation.builder()
                .table(tableItem)
                .reservationRequest(reservationRequest)
                .build();
        reservation_Table_RelationRepository.save(reservation_Table_Relation);
        reservationRequest.setApproved("true");
        reservationRepository.save(reservationRequest);
    }
}
