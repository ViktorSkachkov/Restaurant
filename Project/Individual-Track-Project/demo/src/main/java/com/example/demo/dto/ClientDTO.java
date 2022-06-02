package com.example.demo.dto;

public class ClientDTO extends UserDTO {
    public ClientDTO(Long id, String firstName, String lastName, String username, String password, String email, String address, String phone, boolean logged, String category) {
        super(Math.toIntExact(id), firstName, lastName, username, password, email, address, phone, logged, category);
    }
}