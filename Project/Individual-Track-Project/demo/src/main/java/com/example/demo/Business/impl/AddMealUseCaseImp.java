package com.example.demo.Business.impl;

import com.example.demo.Business.AddMealUseCase;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.dto.CreateMealRequestDTO;
import com.example.demo.dto.CreateMealResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddMealUseCaseImp implements AddMealUseCase {
    private final MealRepository mealRepository;
    private final CategoryRepository categoryRepository;
    @Transactional
    @Override
    public CreateMealResponseDTO createMeal(CreateMealRequestDTO request) {
        Meal savedMeal = saveNewMeal(request);

       return CreateMealResponseDTO.builder()
               .mealName(savedMeal.getName())
               .build();
    }
    private Meal saveNewMeal(CreateMealRequestDTO request) {
        List<Category> categoryList = categoryRepository.findAll();
        Category category = null;
        for(Category c : categoryList) {
            if(c.getName().equals(request.getCategory()))
            {
                category = c;
            }
        }
        Meal newMeal = Meal.builder()
                .image(request.getImage())
                .description(request.getDescription())
                .name(request.getName())
                .category(category)
                .weight(request.getWeight())
                .price(request.getPrice())
                .build();
        return mealRepository.save(newMeal);
    }
}
