package com.example.demo.Business.impl;

import com.example.demo.Business.GetOrdersUseCase;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service
@RequiredArgsConstructor*/
public class GetOrdersUseCaseImp implements GetOrdersUseCase {
    private OrderRepository odh = new OrderRepository();
    @Override
    public List<OrderDTO> GetOrders() {
        return this.odh.GetOrders();
    }
}
