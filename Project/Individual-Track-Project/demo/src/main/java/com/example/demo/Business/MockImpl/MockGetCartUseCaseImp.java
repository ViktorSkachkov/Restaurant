package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetCartUseCase;
import com.example.demo.MockRepositories.*;
import com.example.demo.dto.OrderedMealDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MockGetCartUseCaseImp implements GetCartUseCase {
    private MockCartRepository cdh = new MockCartRepository();
    @Override
    public List<OrderedMealDTO> GetCart() {
        return  cdh.GetOrderedMeals();
    }
}
