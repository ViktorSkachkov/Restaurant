package com.example.demo.RepositoryClasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "adding_cart_relationship")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adding_Cart_Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "adding_id")
    private Adding adding;

    @OneToOne(optional = true)
    @JoinColumn(name = "cart_id")
    private CartItem cartItem;

    @NotBlank
    @Column(name = "approved")
    private String approved;
}
