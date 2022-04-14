package com.example.demo.dto;

import com.example.demo.Normal.User;

public class ClientDTO extends UserDTO {
    public ClientDTO(int id, String firstName, String lastName, String username, String password, String email, String address, String phone) {
        super(id, firstName, lastName, username, password, email, address, phone);
    }
}