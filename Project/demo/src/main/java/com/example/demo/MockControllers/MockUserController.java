package com.example.demo.MockControllers;

import com.example.demo.Administrations.UserAdministration;
import com.example.demo.MockAdministration.MockUserAdministration;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/mockUsers/")

public class MockUserController {
    private UserAdministration userAdministration;
    private MockUserAdministration mockUserAdministration;
    List<UserDTO> users = new ArrayList<>();

    @Autowired
    public MockUserController(MockUserAdministration mockUserAdministration) {
        this.mockUserAdministration = mockUserAdministration;
        users.add(new ClientDTO(1, "Viktor", "Skachkov", "dragonslayer",
                "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785"));
        users.add(new ClientDTO(2,"Pavel", "dimitrov", "bomber",
                "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745"));
        users.add(new ClientDTO(3,"Todor", "Petrov", "kalipso",
                "manhattan", "todor.petrov@gmail.com", "Pieter Breughelstraat 19", "65789809087645"));
        users.add(new ClientDTO(4,"Martin", "Yordanov", "lampofthegenie",
                "Waaargh", "martin.yordanov@gmail.com", "Pieter Breughelstraat 19", "67893424545636"));
        users.add(new ClientDTO(5,"Radostin", "Martinov", "qyburn",
                "uhata", "radostin.martinov@gmail.com", "Pieter Breughelstraat 19", "87964356567645"));
        users.add(new ClientDTO(6,"Wat", "Tambor", "StarWars",
                "starcraft", "Wat.Tambor@gmail.com", "Pieter Breughelstraat 19", "11143565784554"));
        users.add(new WorkerDTO(7,"Sarah", "Kerrigan", "queenOfBlades",
                "zergQueen", "sarah.kerrigan@gmail.com", "Pieter Breughelstraat 19", "234564677886565"));
        users.add(new WorkerDTO(8,"John", "Arryn", "asoiaf",
                "eagleSigil", "john.arryn@gmail.com", "Pieter Breughelstraat 19", "335457689897645"));
        users.add(new WorkerDTO(9,"Katrin", "Jonathan", "romani",
                "TheKingBeyond", "katrin.jonathan@gmail.com", "Pieter Breughelstraat 19", "743578967543434"));
    }

    @GetMapping("clients")
    public List<ClientDTO> GetClients() {
        List<ClientDTO> clients = new ArrayList<>();
        for (UserDTO user : users) {
            if (user instanceof ClientDTO) {
                clients.add((ClientDTO) user);
            }
        }
        return clients;
    }

    @GetMapping("workers")
    public List<WorkerDTO> GetWorkers() {
        List<WorkerDTO> workers = new ArrayList<>();
        for (UserDTO user : users) {
            if (user instanceof WorkerDTO) {
                workers.add((WorkerDTO) user);
            }
        }
        return workers;
    }

    @GetMapping("{username}/{password}")
    public UserDTO GetUser(@PathVariable String username, @PathVariable String password) {
        UserDTO user = null;
        for (UserDTO u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                user = u;
            }
        }
        return user;
    }
}
