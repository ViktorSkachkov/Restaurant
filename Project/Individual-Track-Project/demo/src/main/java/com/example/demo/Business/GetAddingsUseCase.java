package com.example.demo.Business;

import com.example.demo.dto.GetAddingsResponseDTO;

import java.util.List;

public interface GetAddingsUseCase {
    /*OrderRepository or = new OrderRepository();
    public List<AddingDTO> GetAddings(); {
        return or.GetAddings();
    }*/
    GetAddingsResponseDTO getAddings();
}
