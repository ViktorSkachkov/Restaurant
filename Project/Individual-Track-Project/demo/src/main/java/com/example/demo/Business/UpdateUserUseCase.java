package com.example.demo.Business;

import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.UpdateUserRequestDTO;

public interface UpdateUserUseCase {
    User updateUser(UpdateUserRequestDTO request);
}
