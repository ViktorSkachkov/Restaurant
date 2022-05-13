package com.example.demo.dto;

import com.example.demo.Normal.User;

public class ClientDTO extends UserDTO {
    public ClientDTO(Long id, String firstName, String lastName, String username, String password, String email, String address, String phone, boolean logged, String category) {
        super(id, firstName, lastName, username, password, email, address, phone, logged, category);
    }
}