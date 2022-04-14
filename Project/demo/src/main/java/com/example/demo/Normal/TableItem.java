package com.example.demo.Normal;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "table")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "seats")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int seats;

    @NotBlank
    @Column(name = "location")
    private String location;
}
