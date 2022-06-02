package com.example.demo.Business.impl;

import com.example.demo.Business.AddReservationRequestUseCase;
import com.example.demo.RepositoryClasses.ReservationRequest;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.Repositories.ReservationRequestRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.dto.CreateReservationRequestRequestDTO;
import com.example.demo.dto.CreateReservationRequestResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddReservationRequestUseCaseImp implements AddReservationRequestUseCase {
    private final ReservationRequestRepository reservationRequestRepository;
    private final UserItemRepository userRepository;

    @Transactional
    @Override
    public CreateReservationRequestResponseDTO createReservationRequest(CreateReservationRequestRequestDTO createReservationRequestRequestDTO) {
        ReservationRequest savedReservationRequest = saveNewReservation(createReservationRequestRequestDTO);
        return CreateReservationRequestResponseDTO.builder()
                .reservationRequestId(savedReservationRequest.getId())
                .build();
    }
    private ReservationRequest saveNewReservation(CreateReservationRequestRequestDTO createReservationRequestRequestDTO) {
        Optional<User> userOptional = userRepository.findById(createReservationRequestRequestDTO.getClientId());
        User user = userOptional.get();
        ReservationRequest newReservationRequest = ReservationRequest.builder()
                .numberOfPeople(createReservationRequestRequestDTO.getNumberOfPeople())
                .preferences(createReservationRequestRequestDTO.getPreferences())
                .approved("false")
                .user(user)
                .finish_time(createReservationRequestRequestDTO.getFinish_time())
                .start_time(createReservationRequestRequestDTO.getStart_time())
                .build();
        return reservationRequestRepository.save(newReservationRequest);
    }
}
