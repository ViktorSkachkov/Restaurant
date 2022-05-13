package com.example.demo.Normal;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.example.demo.Normal.*;

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
    private int id;

    @NotNull
    @Column(name = "client_id")
    @EqualsAndHashCode.Exclude
    private int clientId;


    @NotBlank
    @Column(name = "preferences")
    private String preferences;

    @Column(name = "number_of_people")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfPeople;

    @Column(name = "time_hour")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double hour;

    @NotNull
    @Column(name = "approved")
    private String approved;
}
