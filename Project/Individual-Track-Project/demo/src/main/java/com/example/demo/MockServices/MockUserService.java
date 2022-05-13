package com.example.demo.MockServices;

import com.example.demo.MockRepositories.MockUserRepository;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockUserService {
    private MockUserRepository mudh = new MockUserRepository();
    public MockUserService(MockUserRepository userDataHelper) {
        this.mudh = userDataHelper;
    }
    public List<ClientDTO> GetClients() {
        List<ClientDTO> clients = new ArrayList<>();
        /*for(UserDTO user : mudh.GetUsers()) {
            if(user instanceof ClientDTO) {
                clients.add((ClientDTO)user);
            }
        }*/
        return clients;
    }
    public List<WorkerDTO> GetWorkers() {
        List<WorkerDTO> workers = new ArrayList<>();
        /*for(UserDTO user : mudh.GetUsers()) {
            if(user instanceof WorkerDTO) {
                workers.add((WorkerDTO) user);
            }
        }*/
        return workers;
    }
    public UserDTO GetUser(String username, String password) {
        UserDTO user = null;
        for(UserDTO u : mudh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                user = u;
            }
        }
        return user;
    }
    public boolean VerifyAccount(String username, String password) {
        for(UserDTO u : mudh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    public boolean addUser(UserDTO user) {
        return true;
    }
    public void deleteUser(UserDTO user) {

    }
}
