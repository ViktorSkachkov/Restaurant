package com.example.demo.RepositoryClasses;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "table_item")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seats")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int seats;

    @NotBlank
    @Column(name = "location")
    private String location;
}
