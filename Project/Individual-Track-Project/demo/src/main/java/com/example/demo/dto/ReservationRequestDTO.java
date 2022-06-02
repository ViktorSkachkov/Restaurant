package com.example.demo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private int id;
    private String preferences;
    private int numberOfPeople;
    private LocalDateTime start_time;
    private LocalDateTime finish_time;
    private String formatted_start_time;
    private String formatted_finish_time;
    private String approved;
    private UserDTO user;
}
