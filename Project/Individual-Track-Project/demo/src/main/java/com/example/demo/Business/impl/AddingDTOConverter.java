package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.dto.AddingDTO;

public class AddingDTOConverter {
    private AddingDTOConverter() {

    }

    public static AddingDTO convertToDTO(Adding adding) {
        return AddingDTO.builder()
                .id(Math.toIntExact(adding.getId()))
                .name(adding.getName())
                .weight(adding.getWeight())
                .price(adding.getPrice())
                .build();
    }
}
