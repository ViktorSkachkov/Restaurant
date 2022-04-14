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
    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;

    @NotBlank
    @Column(name = "image")
    private String image;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "description")
    private String description;


    @Column(name = "weight")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int weight;

    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;
}
