package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.UserDTO;

import java.time.format.DateTimeFormatter;

public class ReservationRequestDTOConverter {
    private ReservationRequestDTOConverter() {

    }
    public static ReservationRequestDTO convertToDTO(ReservationRequest reservationRequest) {
        String formatted_start_time = reservationRequest.getStart_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String formatted_finish_time = reservationRequest.getFinish_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        UserDTO user = UserDTO.builder()
                .id(Math.toIntExact(reservationRequest.getUser().getId()))
                .firstName(reservationRequest.getUser().getFirstName())
                .lastName(reservationRequest.getUser().getLastName())
                .username(reservationRequest.getUser().getUsername())
                .pwd(reservationRequest.getUser().getPwd())
                .email(reservationRequest.getUser().getEmail())
                .address(reservationRequest.getUser().getAddress())
                .phone(reservationRequest.getUser().getPhone())
                .logged(false)
                .category(reservationRequest.getUser().getCategory())
                .build();
        return ReservationRequestDTO.builder()
                .id(Math.toIntExact(reservationRequest.getId()))
                .user(user)
                .preferences(reservationRequest.getPreferences())
                .numberOfPeople(reservationRequest.getNumberOfPeople())
                .start_time(reservationRequest.getStart_time())
                .finish_time(reservationRequest.getFinish_time())
                .formatted_start_time(formatted_start_time)
                .formatted_finish_time(formatted_finish_time)
                .approved(reservationRequest.getApproved())
                .build();
    }
}
