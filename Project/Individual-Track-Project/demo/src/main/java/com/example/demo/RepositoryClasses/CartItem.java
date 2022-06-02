package com.example.demo.RepositoryClasses;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "client_id")
    private User user;

    @OneToOne(optional = true)
    @JoinColumn(name = "ordered_meal_id")
    private Meal meal;


    @NotBlank
    @Column(name = "approved")
    private String approved;

    @Column(name = "number_of_items")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfItems;

    @Column(name = "time_of_order")
    @EqualsAndHashCode.Exclude
    private LocalDateTime timeOfOrder;

    @NotBlank
    @Column(name = "cutlaries_needed")
    private String cutlaries_needed;
}