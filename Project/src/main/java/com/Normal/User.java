package com.Normal;

public class User {
    private String firstName;
private String lastName;
private String username;
private String password;
private String email;
private String address;
private String phone;
        public User(String firstName, String lastName,
              String username, String password, String email,
              String address, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.password = password;
            this.email = email;
            this.address = address;
            this.phone = phone;
        }
        public String Username() {
            return this.username;
        }
}
