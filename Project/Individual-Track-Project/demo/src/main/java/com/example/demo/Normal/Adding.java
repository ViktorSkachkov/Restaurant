package com.example.demo.Normal;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adding")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int weight;

    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;
}
