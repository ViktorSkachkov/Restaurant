package com.example.demo.RepositoryClasses;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
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

    @Column(name = "number_of_items")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int numberOfItems;


    @Column(name = "time_of_order")
    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime timeOfOrder;
}
