package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name = "client")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class Client extends User {
    public Client(int id, String firstName, String lastName, String username, String password, String email, String address, String phone) {
        super(id, firstName, lastName, username, password, email, address, phone);
    }
}
