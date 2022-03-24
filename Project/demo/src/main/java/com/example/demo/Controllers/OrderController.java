package com.example.demo.Controllers;

import com.example.demo.Administrations.*;
import com.example.demo.MockAdministration.MockOrderAdministration;
import com.example.demo.Normal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/individualTrack")
public class OrderController {
    private OrderAdministration orderAdministration;
    private MockOrderAdministration mockOrderAdministration;
    private List<Order> orders;
    private List<Adding> addings;
    private List<Category> categories = new ArrayList<>();

    private List<Meal> meals = new ArrayList<>();
@Autowired
    public OrderController(OrderAdministration orderAdministration) {
        this.orderAdministration = orderAdministration;
        Category c = new Category("Pizza", "./pictures/lasagna.jpg");
        categories.add(c);
        meals.add(new Meal(1, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(2, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(3, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(4, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(5, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(6, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new Meal(7, c, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
    }
    public OrderController(MockOrderAdministration mockOrderAdministration) {
        this.mockOrderAdministration = mockOrderAdministration;
    }
    public List<Order> GetOrders() {
        return this.orders;
    }
    public List<Adding> GetAddings() {
        return this.addings;
    }


    @GetMapping("/Meals")
    public List<Meal> GetMeals() {
        return this.meals;
    }

    @GetMapping("/getIds")
    public List<Integer> GetIds() {
        List<Integer> ids = new ArrayList<>();
        for(Meal meal: meals) {
            ids.add(meal.getId());
        }
        return ids;
    }
    @GetMapping("/getImages")
    public List<String> GetImages() {
        List<String> images = new ArrayList<>();
        for(Meal meal: meals) {
            images.add(meal.getImage());
        }
        return images;
    }
    @GetMapping("/getNames")
    public List<String> GetNames() {
        List<String> names = new ArrayList<>();
        for(Meal meal: meals) {
            names.add(meal.getName());
        }
        return names;
    }
    @GetMapping("/getDescriptions")
    public List<String> GetDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for(Meal meal: meals) {
            descriptions.add(meal.getDescription());
        }
        return descriptions;
    }
    @GetMapping("/getWeights")
    public List<Integer> GetWeights() {
        List<Integer> weights = new ArrayList<>();
        for(Meal meal: meals) {
            weights.add(meal.getWeight());
        }
        return weights;
    }
    @GetMapping("/getPrices")
    public List<Double> GetPrices() {
        List<Double> prices = new ArrayList<>();
        for(Meal meal: meals) {
            prices.add(meal.getPrice());
        }
        return prices;
    }

    @GetMapping("/getNumbers")
    public List<Integer> GetNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        return numbers;
    }
    public List<Category> GetCategories() {
        return this.categories;
    }
    public Order GetOrder() {
        return null;
    }
}
