package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetClientsUseCase;
import com.example.demo.MockRepositories.MockUserRepository;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class MockGetClientsUseCaseImp implements GetClientsUseCase {
    private MockUserRepository udh = new MockUserRepository();
    @Override
    public List<ClientDTO> GetClients() {
        List<ClientDTO> clients = new ArrayList<>();
        for(UserDTO user : udh.GetUsers()) {
            if(user instanceof ClientDTO) {
                clients.add((ClientDTO)user);
            }
        }
        return clients;
    }
}
