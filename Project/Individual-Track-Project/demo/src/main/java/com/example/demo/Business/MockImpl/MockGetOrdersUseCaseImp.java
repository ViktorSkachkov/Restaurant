package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetOrdersUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.OrderDTO;

import java.util.List;

public class MockGetOrdersUseCaseImp implements GetOrdersUseCase {
    private MockOrderRepository odh = new MockOrderRepository();
    @Override
    public List<OrderDTO> GetOrders() {
        return this.odh.GetOrders();
    }
}
