package com.example.demo.Business;

import com.example.demo.dto.UserDTO;

public interface VerifyAccountUseCase {
    public UserDTO VerifyAccount(String username, String password);
}
