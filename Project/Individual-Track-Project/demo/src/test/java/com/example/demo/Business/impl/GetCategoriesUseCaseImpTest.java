package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.Category;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.GetCategoriesResponseDTO;
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
class GetCategoriesUseCaseImpTest {
    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private GetCategoriesUseCaseImp getCategoriesUseCase;

    @Test
    void getCategories() {
        Category category = Category.builder()
                .id(1L)
                .name("Pizza")
                .image("./pictures/lasagna.jpg")
                .build();
        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category));
        GetCategoriesResponseDTO actualResult = getCategoriesUseCase.getCategories();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(1)
                .name("Pizza")
                .image("./pictures/lasagna.jpg")
                .build();
        GetCategoriesResponseDTO expectedResult = GetCategoriesResponseDTO.builder()
                .categories(List.of(categoryDTO))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(categoryRepositoryMock).findAll();
    }
}