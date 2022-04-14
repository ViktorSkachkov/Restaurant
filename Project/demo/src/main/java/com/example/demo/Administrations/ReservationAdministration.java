package com.example.demo.Administrations;

import com.example.demo.DataHelpers.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationAdministration {
    private ReservationDataHelper reservationDataHelper;
    public ReservationAdministration(ReservationDataHelper reservationDataHelper) {
        this.reservationDataHelper = reservationDataHelper;
    }
}
