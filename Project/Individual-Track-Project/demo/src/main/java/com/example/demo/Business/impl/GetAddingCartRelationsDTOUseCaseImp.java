package com.example.demo.Business.impl;

import com.example.demo.Business.GetAddingCartRelationsDTOUseCase;
import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.dto.AddingCartRelationDTO;
import com.example.demo.dto.AddingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAddingCartRelationsDTOUseCaseImp implements GetAddingCartRelationsDTOUseCase {
    private final Adding_Cart_RelationRepository adding_Cart_RelationRepository;

    @Override
    public List<AddingCartRelationDTO> getAddingCartRelationDTO() {
        List<AddingCartRelationDTO> addingRelationshipItems = adding_Cart_RelationRepository.findAll()
                .stream()
                .map(AddingCartRelationDTOConverter::convertToDTO)
                .toList();
        return addingRelationshipItems;
    }
}
