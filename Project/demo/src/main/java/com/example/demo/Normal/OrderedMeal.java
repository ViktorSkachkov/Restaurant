package com.example.demo.Normal;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.*;
import com.example.demo.Normal.*;

@Entity
@Table(name = "orderedMeal")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedMeal {
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "meal_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Meal meal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "addingList",
            joinColumns = @JoinColumn(name = "orderedMeal_id"),
            inverseJoinColumns = @JoinColumn(name = "adding_id"))
    private List<Adding> addingList = new ArrayList<>();

    @Column(name = "totalPrice")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double totalPrice;

    /*public void AddAdding(Adding adding) {
        this.addingList.add(adding);
    }
    public void RemoveAdding(Adding adding) {
        this.addingList.remove(adding);
    }*/
}
