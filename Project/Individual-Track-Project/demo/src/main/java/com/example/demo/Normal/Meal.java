package com.example.demo.Normal;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "meal")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "category")
    private int category;

    @NotBlank
    @Column(name = "image")
    private String image;

    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double weight;

    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "name")
    private String name;
}
