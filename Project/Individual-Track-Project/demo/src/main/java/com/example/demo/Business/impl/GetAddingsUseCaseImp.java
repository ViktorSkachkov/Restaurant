package com.example.demo.Business.impl;

import com.example.demo.Business.GetAddingsUseCase;
import com.example.demo.Repositories.AddingRepository;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.GetAddingsResponseDTO;
import com.example.demo.dto.GetCategoriesResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class GetAddingsUseCaseImp implements GetAddingsUseCase {
    private final AddingRepository addingRepository;
    @Override
    public GetAddingsResponseDTO getAddings() {
        List<AddingDTO> addingItems = addingRepository.findAll()
                .stream()
                .map(AddingDTOConverter::convertToDTO)
                .toList();

        return GetAddingsResponseDTO.builder()
                .addings(addingItems)
                .build();
    }
    /*private OrderRepository odh = new OrderRepository();
    @Override
    public List<AddingDTO> GetAddings() {
        return this.odh.GetAddings();
    }*/

}
