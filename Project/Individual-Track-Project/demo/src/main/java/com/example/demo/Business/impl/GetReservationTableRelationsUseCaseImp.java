package com.example.demo.Business.impl;

import com.example.demo.Business.GetReservationTableRelationsUseCase;
import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import com.example.demo.Repositories.Reservation_Table_RelationRepository;
import com.example.demo.dto.GetReservationTableRelationsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetReservationTableRelationsUseCaseImp implements GetReservationTableRelationsUseCase {
    private final Reservation_Table_RelationRepository reservation_table_relationRepository;

    @Override
    public GetReservationTableRelationsResponseDTO getReservationTableRelations(int id) {
        List<Reservation_Table_Relation> reservation_table_relationList = new ArrayList<>();
                for(Reservation_Table_Relation rr : reservation_table_relationRepository.findAll())
                {
                    if(rr.getReservationRequest().getId() == id)
                    {
                        reservation_table_relationList.add(rr);
                    }
                }
        return GetReservationTableRelationsResponseDTO.builder()
                .reservation_table_relationList(reservation_table_relationList)
                .build();
    }
}
