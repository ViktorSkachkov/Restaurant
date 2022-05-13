package com.example.demo.Normal;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.*;
import com.example.demo.Normal.*;

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
    private int id;

    @NotNull
    @Column(name = "client_id")
    @EqualsAndHashCode.Exclude
    private int userId;

    @NotNull
    @Column(name = "meal_id")
    @EqualsAndHashCode.Exclude
    private int mealId;
}
