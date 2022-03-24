package com.example.demo.Administrations;

import com.example.demo.DataHelpers.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderAdministration {
    private OrderDataHelper orderDataHelper;
    public OrderAdministration(OrderDataHelper orderDataHelper) {
        this.orderDataHelper = orderDataHelper;
    }
    public OrderDataHelper GetOrderDataHelper() {
        return this.orderDataHelper;
    }
}
