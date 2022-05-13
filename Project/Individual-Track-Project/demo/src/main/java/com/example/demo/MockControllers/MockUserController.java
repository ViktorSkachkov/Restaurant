package com.example.demo.MockControllers;

import com.example.demo.Business.GetClientsUseCase;
//import com.example.demo.Business.GetUserUseCase;
import com.example.demo.Business.MockImpl.*;
import com.example.demo.MockServices.MockUserService;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/mockUsers/")

public class MockUserController {
    private MockUserService mockUserAdministration;
    private MockGetClientsUseCaseImp getClientsUseCaseImp = new MockGetClientsUseCaseImp();
    private MockGetWorkersUseCaseImp getWorkersUseCaseImp = new MockGetWorkersUseCaseImp();
    private MockGetUserUseCaseImp getUserUseCaseImp = new MockGetUserUseCaseImp();
    @Autowired
    public MockUserController(MockUserService mockUserAdministration) {
        this.mockUserAdministration = mockUserAdministration;
    }

    @GetMapping("clients")
    public List<ClientDTO> GetClients() {
        return getClientsUseCaseImp.GetClients();
    }

    @GetMapping("workers")
    public List<WorkerDTO> GetWorkers() {
        return getWorkersUseCaseImp.GetWorkers();
    }

    @GetMapping("{username}/{password}")
    public UserDTO GetUser(@PathVariable String username, @PathVariable String password) {
        return getUserUseCaseImp.GetUser(username, password);
    }
}
