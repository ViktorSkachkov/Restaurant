package com.example.demo.Normal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "firstName")
    protected String firstName;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "lastName")
    protected String lastName;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "username")
    protected String username;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "password")
    protected String password;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "email")
    protected String email;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "address")
    protected String address;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "phone")
    protected String phone;
}
