package com.example.demo.dto;

import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddingCartRelationDTO {
    private int id;
    private AddingDTO adding;
    private CartItemDTO cartItem;
    private String approved;

}
