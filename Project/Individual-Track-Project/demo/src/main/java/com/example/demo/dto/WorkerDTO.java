package com.example.demo.dto;


public class WorkerDTO extends UserDTO {
    public WorkerDTO(Long id, String firstName, String lastName, String username, String password, String email, String address, String phone, boolean logged, String category) {
        super(id, firstName, lastName, username, password, email, address, phone, logged, category);
    }
}
