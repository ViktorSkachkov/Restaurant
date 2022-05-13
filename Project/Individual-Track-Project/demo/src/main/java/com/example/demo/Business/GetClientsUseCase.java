package com.example.demo.Business;

import com.example.demo.dto.ClientDTO;

import java.util.List;

public interface GetClientsUseCase {
    public List<ClientDTO> GetClients();
}
