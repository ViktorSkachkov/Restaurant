package com.example.demo.Business.impl;

import com.example.demo.Business.VerifyAccountUseCase;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.UserDTO;

public class VerifyAccountUseCaseImp implements VerifyAccountUseCase {
    private UserRepository udh = new UserRepository();
    @Override
    public UserDTO VerifyAccount(String username, String password) {
        UserDTO user = null;
        for(UserDTO u : udh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                u.setLogged(true);
                user = u;
            }
        }
        return user;
    }
}
