package com.example.demo.RepositoryClasses;

import com.mysql.cj.jdbc.Blob;
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
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "category")
    private Category category;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "image", length=100000)
    private String image;

    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double weight;

    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "name")
    private String name;
}
