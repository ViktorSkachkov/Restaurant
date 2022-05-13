package com.example.demo.Business.MockImpl;

//import com.example.demo.Business.GetUserUseCase;
import com.example.demo.MockRepositories.MockUserRepository;
import com.example.demo.dto.UserDTO;

public class MockGetUserUseCaseImp /*implements GetUserUseCase*/ {
    private MockUserRepository udh = new MockUserRepository();
    /*@Override*/
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
}
