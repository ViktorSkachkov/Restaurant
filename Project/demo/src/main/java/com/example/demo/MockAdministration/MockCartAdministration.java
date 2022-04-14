package com.example.demo.MockAdministration;

import com.example.demo.MockDataHelpers.MockCartDataHelper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MockCartAdministration {
    MockCartDataHelper mockCartDataHelper;
    public MockCartAdministration(MockCartDataHelper mockCartDataHelper) {
        this.mockCartDataHelper = mockCartDataHelper;
    }
}
