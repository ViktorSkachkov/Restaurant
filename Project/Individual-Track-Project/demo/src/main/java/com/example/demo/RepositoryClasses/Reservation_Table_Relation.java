package com.example.demo.RepositoryClasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "reservation_table_relationship")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation_Table_Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "reservation_id")
    private ReservationRequest reservationRequest;

    @OneToOne(optional = true)
    @JoinColumn(name = "table_id")
    private TableItem table;
}
