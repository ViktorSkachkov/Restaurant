package com.example.demo.RepositoryClasses;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderedmeal")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "client_id")
    @EqualsAndHashCode.Exclude
    private int userId;

    @NotNull
    @Column(name = "meal_id")
    @EqualsAndHashCode.Exclude
    private int mealId;
}
