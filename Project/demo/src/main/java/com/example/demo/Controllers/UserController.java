package com.example.demo.Controllers;

import com.example.demo.Administrations.*;
import com.example.demo.MockAdministration.*;
import com.example.demo.Normal.*;

import java.util.*;

public class UserController {
    private UserAdministration userAdministration;
    private MockUserAdministration mockUserAdministration;
    List<User> users;
    public UserController(UserAdministration userAdministration) {
        this.userAdministration = userAdministration;
    }
    public UserController(MockUserAdministration mockUserAdministration) {
        this.mockUserAdministration = mockUserAdministration;
    }
    public List<Client> GetClients() {
        List<Client> clients = new ArrayList<Client>();
        for(User user : users) {
            if(user instanceof Client) {
                clients.add((Client)user);
            }
        }
        return clients;
    }
    public List<Worker> GetWorkers() {
        List<Worker> workers = new ArrayList<Worker>();
        for(User user : users) {
            if(user instanceof Worker) {
                workers.add((Worker) user);
            }
        }
        return workers;
    }
    public User GetUser(String username, String password) {
        User user = null;
        for(User u : users) {
            if(u.getUsername() == username && u.getPassword() == password)
            {
                user = u;
            }
        }
        return user;
    }
}
