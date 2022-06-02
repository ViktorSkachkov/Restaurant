package com.example.demo.dto;

import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrder {
    private int id;
    private UserDTO user;
    private List<CartItemDTO> cartItems;
    private List<Adding_Cart_Relation> adding_cart_relations;
}
