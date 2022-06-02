package com.example.demo.Business.impl;

import com.example.demo.Business.UpdateMealUseCase;
import com.example.demo.RepositoryClasses.Category;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.dto.UpdateMealRequestDTO;
import com.example.demo.dto.UpdateMealResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateMealUseCaseImp implements UpdateMealUseCase {
    private final MealRepository mealRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    @Override
    public UpdateMealResponseDTO updateMeal(UpdateMealRequestDTO requestDTO) {
        Optional<Meal> mealOptional = mealRepository.findById((long) requestDTO.getId());
        Meal meal = mealOptional.get();
        updateFields(requestDTO, meal);
        UpdateMealResponseDTO mealResponseDTO = UpdateMealResponseDTO.builder()
                .mealName(meal.getName())
                .build();
        return mealResponseDTO;
    }

    private void updateFields(UpdateMealRequestDTO request, Meal meal) {
        Category category = null;
        List<Category> categoryList = categoryRepository.findAll();
        for(Category c : categoryList) {
            if(c.getName().equals(request.getCategory()))
            {
                category = c;
            }
        }
        meal.setName(request.getName());
        meal.setDescription(request.getDescription());
        meal.setImage(request.getImage());
        meal.setPrice(request.getPrice());
        meal.setWeight(request.getWeight());
        meal.setCategory(category);

        mealRepository.save(meal);
    }
}
