package com.example.demo.Business;

import com.example.demo.dto.GetUsersResponseDTO;

public interface GetUsersUseCase {
    GetUsersResponseDTO getUsers(long userId);
}
