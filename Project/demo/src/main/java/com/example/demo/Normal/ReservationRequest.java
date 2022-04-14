package com.example.demo.Normal;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.example.demo.Normal.*;

@Entity
@Table(name = "reservationRequest")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User client;


    @NotBlank
    @Column(name = "preferences")
    private String preferences;

    @Column(name = "numberOfPeople")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfPeople;

    @Column(name = "hour")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double hour;

    @NotBlank
    @Column(name = "approved")
    private String approved;
}
