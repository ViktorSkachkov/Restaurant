package com.example.demo.Business.impl;

import com.example.demo.Business.GetAddingCartRelationsUseCase;
import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.dto.GetAddingCartRelationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAddingCartRelationsUseCaseImp implements GetAddingCartRelationsUseCase {
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;
    @Override
    public GetAddingCartRelationResponseDTO getAddingCartRelations() {
        List<Adding_Cart_Relation> all_adding_cart_relations = adding_Cart_RelationRepository.findAll();
        List<Adding_Cart_Relation> return_adding_cart_relations = new ArrayList<>();
        for(Adding_Cart_Relation adding_cart_relation : all_adding_cart_relations) {
            //if(adding_cart_relation.getCartItem().getUser().getId() == id) {
                return_adding_cart_relations.add(adding_cart_relation);
            //}
        }

        return GetAddingCartRelationResponseDTO.builder()
                .addingDTOList(return_adding_cart_relations)
                .build();
    }
}
