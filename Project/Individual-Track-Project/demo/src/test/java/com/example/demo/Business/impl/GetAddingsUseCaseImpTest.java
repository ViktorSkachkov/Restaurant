package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.Repositories.AddingRepository;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.GetAddingsResponseDTO;
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
class GetAddingsUseCaseImpTest {
    @Mock
    private AddingRepository addingRepositoryMock;

    @InjectMocks
    private GetAddingsUseCaseImp getAddingsUseCase;

    @Test
    void getAddings() {
        Adding adding = Adding.builder()
                .id(1L)
                .name("Garlic")
                .price(1)
                .weight(50)
                .build();
        when(addingRepositoryMock.findAll()).thenReturn(List.of(adding));
        GetAddingsResponseDTO actualResult = getAddingsUseCase.getAddings();
        AddingDTO addingDTO = AddingDTO.builder()
                .id(1)
                .name("Garlic")
                .price(1)
                .weight(50)
                .build();
        GetAddingsResponseDTO expectedResult = GetAddingsResponseDTO.builder()
                .addings(List.of(addingDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(addingRepositoryMock).findAll();
    }
}