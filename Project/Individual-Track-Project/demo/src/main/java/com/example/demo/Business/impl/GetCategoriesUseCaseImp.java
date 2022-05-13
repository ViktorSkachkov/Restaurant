package com.example.demo.Business.impl;

import com.example.demo.Business.GetCategoriesUseCase;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.GetCategoriesResponseDTO;
import com.example.demo.dto.GetMealsResponseDTO;
import com.example.demo.dto.MealDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class GetCategoriesUseCaseImp implements GetCategoriesUseCase {
    private final CategoryRepository categoryRepository;
    @Override
    public GetCategoriesResponseDTO getCategories() {
        List<CategoryDTO> categoryItems = categoryRepository.findAll()
                .stream()
                .map(CategoryDTOConverter::convertToDTO)
                .toList();

        return GetCategoriesResponseDTO.builder()
                .categories(categoryItems)
                .build();
    }
}
