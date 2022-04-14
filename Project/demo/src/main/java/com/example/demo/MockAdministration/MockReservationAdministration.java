package com.example.demo.MockAdministration;

import com.example.demo.DataHelpers.ReservationDataHelper;
import com.example.demo.MockDataHelpers.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MockReservationAdministration {
    private MockReservationDataHelper mockReservationDataHelper;
    public MockReservationAdministration(MockReservationDataHelper mockReservationDataHelper) {
        this.mockReservationDataHelper = mockReservationDataHelper;
    }
}
