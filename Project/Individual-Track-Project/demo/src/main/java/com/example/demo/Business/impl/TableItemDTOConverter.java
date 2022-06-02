package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.dto.TableItemDTO;

final class TableItemDTOConverter {
    private TableItemDTOConverter() {

    }
    public static TableItemDTO convertToDTO(TableItem tableItem) {
        return TableItemDTO.builder()
                .id(Math.toIntExact(tableItem.getId()))
                .seats(tableItem.getSeats())
                .location(tableItem.getLocation())
                .build();
    }
}
