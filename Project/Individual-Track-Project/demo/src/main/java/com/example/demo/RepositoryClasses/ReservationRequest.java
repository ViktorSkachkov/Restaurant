package com.example.demo.RepositoryClasses;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation_request")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "client_id")
    private User user;


    @NotBlank
    @Column(name = "preferences")
    private String preferences;

    @Column(name = "number_of_people")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfPeople;

    @Column(name = "start_time")
    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime start_time;

    @Column(name = "finish_time")
    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime finish_time;

    @NotNull
    @Column(name = "approved")
    private String approved;
}
