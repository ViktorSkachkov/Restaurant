package com.example.demo.dto;

import com.example.demo.RepositoryClasses.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAddingCartRelationResponseDTO {
    private List<Adding_Cart_Relation> addingDTOList;
}
