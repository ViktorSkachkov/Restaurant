package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Worker extends User{
    public Worker(String firstName, String lastName, String username, String password, String email, String address, String phone) {
        super(firstName, lastName, username, password, email, address, phone);
    }
}
