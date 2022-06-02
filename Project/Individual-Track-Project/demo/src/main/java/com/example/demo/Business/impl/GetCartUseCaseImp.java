package com.example.demo.Business.impl;

import com.example.demo.Business.GetCartUseCase;
import com.example.demo.Repositories.CartRepository;
import com.example.demo.dto.OrderedMealDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCartUseCaseImp implements GetCartUseCase {
    private CartRepository cdh = new CartRepository();

    @Override
    public List<OrderedMealDTO> getCart() {
        return  cdh.GetOrderedMeals();
    }
}
