package com.example.demo.Administrations;

import com.example.demo.DataHelpers.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderAdministration {
    private final OrderDataHelper orderDataHelper;
    /*public OrderAdministration(OrderDataHelper orderDataHelper) {
        this.orderDataHelper = orderDataHelper;
    }*/
   /* public OrderDataHelper GetOrderDataHelper() {
        return this.orderDataHelper;
    }*/
}
