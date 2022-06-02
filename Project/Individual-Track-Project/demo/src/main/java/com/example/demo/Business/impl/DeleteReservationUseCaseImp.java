package com.example.demo.Business.impl;

import com.example.demo.Business.DeleteReservationUseCase;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.Reservation_Table_RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteReservationUseCaseImp implements DeleteReservationUseCase {
    private final ReservationRequestRepository reservationRepository;
    private final Reservation_Table_RelationRepository reservation_Table_RelationRepository;
    @Override
    /*@Transactional*/
    public ReservationRequest deleteReservation(long id) {
        List<ReservationRequest> reservationRequests = reservationRepository.findAll();
        ReservationRequest reservationRequest = null;
        for(ReservationRequest rr : reservationRequests) {
            if(id == rr.getId())
            {
                reservationRequest = rr;
            }
        }
        this.reservationRepository.delete(reservationRequest);
        List<Reservation_Table_Relation> reservation_table_relationList = new ArrayList<>();
        for(Reservation_Table_Relation reservation_table_relation : reservation_Table_RelationRepository.findAll())
        {
            if(reservation_table_relation.getReservationRequest().getId() == id) {
                reservation_table_relationList.add(reservation_table_relation);
            }
        }
        for(Reservation_Table_Relation reservation_table_relation : reservation_table_relationList) {
            reservation_Table_RelationRepository.delete(reservation_table_relation);
        }
        return reservationRequest;
    }
}
