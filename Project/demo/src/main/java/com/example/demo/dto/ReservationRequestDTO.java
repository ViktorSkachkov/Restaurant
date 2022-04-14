package com.example.demo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private int id;
    private UserDTO client;
    private DateTimeFormat date;
    private String preferences;
    private int numberOfPeople;
    private double hour;
    private boolean approved;
    public boolean getApproved() {
        return approved;
    }
}
