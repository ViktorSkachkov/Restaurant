package com.example.demo.Normal;

import lombok.*;
import org.springframework.core.Ordered;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.*;

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

    @NotNull
    @Column(name = "client_id")
    @EqualsAndHashCode.Exclude
    private int user;

    @NotNull
    @Column(name = "ordered_meal_id")
    @EqualsAndHashCode.Exclude
    private int orderedMeal;

    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;
}
