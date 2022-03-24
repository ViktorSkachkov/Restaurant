package com.example.demo.MockAdministration;

import com.example.demo.DataHelpers.OrderDataHelper;
import com.example.demo.MockDataHelpers.*;

public class MockOrderAdministration {
    private MockOrderDataHelper mockOrderDataHelper;
    public MockOrderAdministration(MockOrderDataHelper mockOrderDataHelper) {
        this.mockOrderDataHelper = mockOrderDataHelper;
    }
    public MockOrderDataHelper GetOrderDataHelper() {
        return this.mockOrderDataHelper;
    }
}
