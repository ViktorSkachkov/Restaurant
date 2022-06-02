package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.TableItem;
import com.example.demo.Repositories.TableItemRepository;
import com.example.demo.dto.GetTableItemsResponseDTO;
import com.example.demo.dto.TableItemDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetTableItemsUseCaseImpTest {
    @Mock
    private TableItemRepository tableItemRepositoryMock;

    @InjectMocks
    private GetTableItemsUseCaseImp getTableItemsUseCase;

    @Test
    void getTableItems() {
        TableItem tableItem = TableItem.builder()
                .id(1L)
                .location("Outside")
                .seats(4)
                .build();
        when(tableItemRepositoryMock.findAll()).thenReturn(List.of(tableItem));
        GetTableItemsResponseDTO actualResult = getTableItemsUseCase.getTableItems();
        TableItemDTO tableItemDTO = TableItemDTO.builder()
                .id(1)
                .location("Outside")
                .seats(4)
                .build();
        GetTableItemsResponseDTO expectedResult = GetTableItemsResponseDTO.builder()
                .tableItems(List.of(tableItemDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(tableItemRepositoryMock).findAll();
    }
}