package com.example.demo.RepositoryClasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "adding_order_relationship")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adding_Order_Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "adding_id")
    private Adding adding;

    @OneToOne(optional = true)
    @JoinColumn(name = "order_id")
    private Order order;
}
