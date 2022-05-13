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
public class Client{
    public Client(int id, String firstName, String lastName, String username, String password, String email, String address, String phone, String category) {
    }
}
