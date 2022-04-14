package com.example.demo.MockAdministration;

import com.example.demo.DataHelpers.OrderDataHelper;
import com.example.demo.MockDataHelpers.*;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MockOrderAdministration {
    private MockOrderDataHelper mockOrderDataHelper;
    public MockOrderAdministration(MockOrderDataHelper mockOrderDataHelper) {
        this.mockOrderDataHelper = mockOrderDataHelper;
    }
    public MockOrderDataHelper GetOrderDataHelper() {
        return this.mockOrderDataHelper;
    }
}
