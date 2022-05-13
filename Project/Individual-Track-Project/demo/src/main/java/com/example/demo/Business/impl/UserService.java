package com.example.demo.Business.impl;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository udh = new UserRepository();
    public UserService(UserRepository userDataHelper) {
        this.udh = userDataHelper;
    }
    public List<ClientDTO> GetClients() {
        List<ClientDTO> clients = new ArrayList<>();
        for(UserDTO user : udh.GetUsers()) {
            if(user instanceof ClientDTO) {
                clients.add((ClientDTO)user);
            }
        }
        return clients;
    }
    public List<WorkerDTO> GetWorkers() {
        List<WorkerDTO> workers = new ArrayList<>();
        for(UserDTO user : udh.GetUsers()) {
            if(user instanceof WorkerDTO) {
                workers.add((WorkerDTO) user);
            }
        }
        return workers;
    }
    public UserDTO GetUser(String username, String password) {
        UserDTO user = null;
        for(UserDTO u : udh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                user = u;
            }
        }
        return user;
    }
    public UserDTO VerifyAccount(String username, String password) {
        for(UserDTO u : udh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                u.setLogged(true);
                return u;
            }
        }
        return null;
    }
    public boolean addUser(UserDTO user) {
        return true;
    }
    public void deleteUser(UserDTO user) {

    }
}
