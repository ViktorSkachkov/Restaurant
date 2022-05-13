package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetAddingsUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.AddingDTO;

import java.util.List;

public class MockGetAddingsUseCaseImp /*implements GetAddingsUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override*/
    public List<AddingDTO> GetAddings() {
        return this.odh.GetAddings();
    }
}
