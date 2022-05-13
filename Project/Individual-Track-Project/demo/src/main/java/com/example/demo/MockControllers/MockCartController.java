package com.example.demo.MockControllers;

import com.example.demo.Business.MockImpl.*;
import com.example.demo.MockServices.MockCartService;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/mockCart/")
public class MockCartController {
    private MockCartService mca = new MockCartService();
    private MockGetCartUseCaseImp getCartUseCase = new MockGetCartUseCaseImp();
    private MockGetOrderedMealsUseCaseImp getMealsUseCase = new MockGetOrderedMealsUseCaseImp();
    private MockGetOrderedMealUseCaseImp getOrderedMealUseCase = new MockGetOrderedMealUseCaseImp();
    @Autowired
    public MockCartController(MockCartService mockCartAdministration) {
        this.mca = mockCartAdministration;
    }
    @GetMapping("orderedMeals")
    public List<OrderedMealDTO> GetCart() {
        return  getCartUseCase.GetCart();
    }
    @GetMapping("{username}")
    public List<OrderedMealDTO> GetMeals(@PathVariable String username) {
       return getMealsUseCase.GetMeals(username);
    }
    @GetMapping("{id}")
    public OrderedMealDTO GetOrderedMeal(@PathVariable int id)
    {
        return getOrderedMealUseCase.GetOrderedMeal(id);
    }
}
