package com.example.demo.Business.MockImpl;

import com.example.demo.Business.GetCategoriesUseCase;
import com.example.demo.MockRepositories.MockOrderRepository;
import com.example.demo.dto.CategoryDTO;

import java.util.List;

public class MockGetCategoriesUseCaseImp /*implements GetCategoriesUseCase*/ {
    private MockOrderRepository odh = new MockOrderRepository();
    /*@Override*/
    public List<CategoryDTO> getCategories() {
        return odh.GetCategories();
    }
}
