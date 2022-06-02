package com.example.demo.Controllers;

import com.example.demo.Business.*;

import com.example.demo.RepositoryClasses.User;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final GetUsersUseCase getUsersUseCase;
    private final AddUserUseCase addUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping
    public CreateUserResponseDTO createUser(@RequestBody @Valid CreateUserRequestDTO createUserRequest) {
       return addUserUseCase.createUser(createUserRequest);
    }




    /*@IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping("updateUser")
    public User updateUser(@RequestBody @Valid UpdateUserRequestDTO updateUserRequest) {
        return updateUserUseCase.updateUser(updateUserRequest);
    }*/

   @IsAuthenticated
   @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/clients")
    public List<UserDTO> GetClients(/*@PathVariable(value = "id") final long id*/) {

        List<UserDTO> clients = new ArrayList<>();
        int id = 0;
        for(UserDTO user : getUsersUseCase.getUsers(id).getUsers()) {
            if(user.getCategory().equals("CLIENT")) {
                clients.add(user);
            }
        }
        return clients;
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER", "ROLE_CLIENT"})
    @GetMapping("/{id}")
    public /*Optional<*/UserDTO/*>*/ GetUser(@PathVariable(value = "id") final long id) {

        UserDTO user = new UserDTO();
        for(UserDTO u : getUsersUseCase.getUsers(id).getUsers()) {
            if(u.getId() == id) {
                user = u;
            }
        }
        return user;
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/workers")
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
/*@GetMapping("verification/{username}/{password}")
    public UserDTO VerifyAccount(@PathVariable String username, @PathVariable String password) {
    return verifyAccountUseCaseImp.VerifyAccount(username, password);
}*/
}
