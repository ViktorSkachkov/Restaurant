package com.example.demo.dto;

import com.example.demo.RepositoryClasses.Reservation_Table_Relation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetReservationTableRelationsResponseDTO {
    List<Reservation_Table_Relation> reservation_table_relationList;
}
