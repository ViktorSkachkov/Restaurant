package com.example.demo.Business;

import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;

public interface LoginUseCase {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
    AccessTokenDTO generateToken(Long id, String username);
}
