package com.example.demo.Business.impl;

import com.example.demo.Business.GetTableItemsUseCase;
import com.example.demo.Repositories.TableItemRepository;
import com.example.demo.dto.GetTableItemsResponseDTO;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTableItemsUseCaseImp implements GetTableItemsUseCase {
    private final TableItemRepository tableItemRepository;
    @Override
    public GetTableItemsResponseDTO getTableItems() {
        List<TableItemDTO> tables = tableItemRepository.findAll()
                .stream()
                .map(TableItemDTOConverter::convertToDTO)
                .toList();

        return GetTableItemsResponseDTO.builder()
                .tableItems(tables)
                .build();
    }
}
