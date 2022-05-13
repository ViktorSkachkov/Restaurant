package com.example.demo.Business;

import com.example.demo.dto.OrderDTO;

import java.util.List;

public interface GetOrdersUseCase {
    public List<OrderDTO> GetOrders();
}
