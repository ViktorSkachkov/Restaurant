package com.example.demo.Business;

import com.example.demo.RepositoryClasses.Meal;

public interface DeleteMealUseCase {
    Meal deleteMeal(long id);
}
