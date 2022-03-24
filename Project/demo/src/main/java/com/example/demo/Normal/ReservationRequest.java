package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
public class ReservationRequest {
    private int id;
    private Client client;
    private DateTimeFormat date;
    private String preferences;
    private int numberOfPeople;
    private double hour;
    private boolean approved;
    public boolean getApproved() {
        return this.approved;
    }
}
