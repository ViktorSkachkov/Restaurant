package com.example.demo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private int id;
    private int client;
    //private DateTimeFormat date;
    private String preferences;
    private int numberOfPeople;
    private double hour;
    private String approved;
    /*public boolean getApproved() {
        return approved;
    }*/
}
