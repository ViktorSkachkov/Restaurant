package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Worker extends User{
    public Worker(int id, String firstName, String lastName, String username, String password, String email, String address, String phone) {
        super(id, firstName, lastName, username, password, email, address, phone);
    }
}
