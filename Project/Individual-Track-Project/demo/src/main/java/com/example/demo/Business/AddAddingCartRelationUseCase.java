package com.example.demo.Business;

import com.example.demo.dto.CreateCartItemResponseDTO;

import java.util.List;

public interface AddAddingCartRelationUseCase {
    void createAddingCartRelation(List<Integer> addings, CreateCartItemResponseDTO createCartItemResponseDTO);
}
