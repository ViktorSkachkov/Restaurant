package com.example.demo.Business.impl;

import com.example.demo.Business.DeleteMealUseCase;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.Repositories.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class DeleteMealUseCaseImp implements DeleteMealUseCase {
    private final MealRepository mealRepository;
    @Override
    /*@Transactional*/
    public Meal deleteMeal(long id) {
       List<Meal> meals = this.mealRepository.findAll();
       Meal meal = null;
       for(Meal m : meals) {
           if(id == m.getId())
           {
               meal = m;
           }
       }
       mealRepository.delete(meal);
        return meal;
    }
}
