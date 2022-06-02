package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequestRequestDTO {
    @NotNull
    @EqualsAndHashCode.Exclude
    private long clientId;

    @NotBlank
    private String preferences;

    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfPeople;

    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime start_time;

    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime finish_time;
}
