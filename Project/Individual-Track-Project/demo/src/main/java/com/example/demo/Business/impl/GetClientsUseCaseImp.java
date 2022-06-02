package com.example.demo.Business.impl;

import com.example.demo.Business.GetClientsUseCase;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*@Service
@RequiredArgsConstructor*/
public class GetClientsUseCaseImp implements GetClientsUseCase {
    private UserRepository udh = new UserRepository();
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
