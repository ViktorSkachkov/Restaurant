package com.example.demo.Repositories;

import com.example.demo.Normal.OrderedMeal;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public interface OrderedMealRepository extends JpaRepository<OrderedMeal, Integer> {

 boolean existsById(Integer index);
}
