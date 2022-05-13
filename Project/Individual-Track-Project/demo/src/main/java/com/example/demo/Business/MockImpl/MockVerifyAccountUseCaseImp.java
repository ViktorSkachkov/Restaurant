package com.example.demo.Business.MockImpl;

import com.example.demo.Business.VerifyAccountUseCase;
import com.example.demo.MockRepositories.MockUserRepository;
import com.example.demo.dto.UserDTO;

public class MockVerifyAccountUseCaseImp implements VerifyAccountUseCase {
    private MockUserRepository udh = new MockUserRepository();
    @Override
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
}
