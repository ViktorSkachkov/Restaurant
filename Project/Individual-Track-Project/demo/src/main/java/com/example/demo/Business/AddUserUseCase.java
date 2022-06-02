package com.example.demo.Business;

import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;

public interface AddUserUseCase {
    CreateUserResponseDTO createUser(CreateUserRequestDTO request);
}
