package com.example.demo.Normal;

import lombok.*;
import org.springframework.core.Ordered;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "order")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @Column(name = "totalPrice")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double totalPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orderedMealList",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "orderedMeal_id"))
    private List<OrderedMeal> orderedMealList = new ArrayList<>();
/*
    public void AddMeal(OrderedMeal orderedMeal) {
        this.orderedMealList.add(orderedMeal);
    }
    public void RemoveMeal(OrderedMeal orderedMeal) {
        this.orderedMealList.remove(orderedMeal);
    }
    public void AddANumberOfMeals(OrderedMeal orderedMeal, int number) {

    }
    public boolean RemoveANumberOfMeals(OrderedMeal orderedMeal, int number) {
        return true;
    }*/
}
