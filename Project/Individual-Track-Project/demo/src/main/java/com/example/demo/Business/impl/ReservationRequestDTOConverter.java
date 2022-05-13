package com.example.demo.Business.impl;

import com.example.demo.Normal.ReservationRequest;
import com.example.demo.Normal.TableItem;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.TableItemDTO;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReservationRequestDTOConverter {
    private ReservationRequestDTOConverter() {

    }
    public static ReservationRequestDTO convertToDTO(ReservationRequest reservationRequest) {
        return ReservationRequestDTO.builder()
                .id(reservationRequest.getId())
                .client(reservationRequest.getClientId())
                .preferences(reservationRequest.getPreferences())
                .numberOfPeople(reservationRequest.getNumberOfPeople())
                .hour(reservationRequest.getHour())
                .approved(reservationRequest.getApproved())
                .build();
    }
}
