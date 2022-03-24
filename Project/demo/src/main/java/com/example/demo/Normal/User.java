package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String email;
    protected String address;
    protected String phone;
}
