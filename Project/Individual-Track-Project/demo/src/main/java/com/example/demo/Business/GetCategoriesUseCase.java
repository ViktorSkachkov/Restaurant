package com.example.demo.Business;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.GetCategoriesResponseDTO;

import java.util.List;

public interface GetCategoriesUseCase {
    /*public List<CategoryDTO> GetCategories();*/
    GetCategoriesResponseDTO getCategories();
}
