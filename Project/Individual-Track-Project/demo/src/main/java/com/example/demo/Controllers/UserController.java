package com.example.demo.Controllers;

import com.example.demo.Business.GetClientsUseCase;
import com.example.demo.Business.GetTableItemsUseCase;
//import com.example.demo.Business.GetUserUseCase;
import com.example.demo.Business.GetUsersUseCase;
import com.example.demo.Business.impl.*;
import com.example.demo.MockServices.*;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;
import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {
    private UserService ua = new UserService();
    private MockUserService mockUserAdministration;
    private GetClientsUseCaseImp getClientsUseCaseImp = new GetClientsUseCaseImp();
    private GetWorkersUseCaseImp getWorkersUseCaseImp = new GetWorkersUseCaseImp();
    //private GetUserUseCaseImp getUserUseCaseImp = new GetUserUseCaseImp();
    private VerifyAccountUseCaseImp verifyAccountUseCaseImp = new VerifyAccountUseCaseImp();

    List<UserDTO> users = new ArrayList<>();
    private boolean match;
    private final GetUsersUseCase getUsersUseCase;
    //private final GetUserUseCase getUserUseCase;
   /* @Autowired
    public UserController(UserService userAdministration) {
        this.ua = userAdministration;
    }*/
   @IsAuthenticated
   @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("clients")
    public List<UserDTO> GetClients(/*@PathVariable(value = "id") final long id*/) {

        List<UserDTO> clients = new ArrayList<>();
        int id = 0;
        for(UserDTO user : getUsersUseCase.getUsers(id).getUsers()) {
            if(user.getCategory().equals("CLIENT")) {
                clients.add(user);
            }
        }
        return clients;
        //return getClientsUseCaseImp.GetClients();
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER", "ROLE_CLIENT"})
    @GetMapping("{id}")
    public /*Optional<*/UserDTO/*>*/ GetUser(@PathVariable(value = "id") final long id) {

        UserDTO user = new UserDTO();
        for(UserDTO u : getUsersUseCase.getUsers(id).getUsers()) {
            if(u.getId() == id) {
                user = u;
            }
        }
        return user;
       // final Optional<UserDTO> userOptional = getUserUseCase.getUser(id);
        //return userOptional;
        //return getClientsUseCaseImp.GetClients();
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("workers")
    public List<UserDTO> GetWorkers(/*@PathVariable(value = "id") final long id*/) {
        List<UserDTO> workers = new ArrayList<>();
        int id = 0;
        for(UserDTO user : getUsersUseCase.getUsers(id).getUsers()) {
            if(user.getCategory().equals("WORKER")) {
                workers.add(user);
            }
        }
        return workers;
        //return getWorkersUseCaseImp.GetWorkers();
    }
    /*@GetMapping("{username}/{password}")
    public UserDTO GetUser(@PathVariable String username,@PathVariable String password) {
        return getUserUseCaseImp.GetUser(username, password);
    }*/
@GetMapping("verification/{username}/{password}")
    public UserDTO VerifyAccount(@PathVariable String username, @PathVariable String password) {
    return verifyAccountUseCaseImp.VerifyAccount(username, password);
}
}
