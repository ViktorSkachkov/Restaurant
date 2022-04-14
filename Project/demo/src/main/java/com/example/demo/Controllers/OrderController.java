package com.example.demo.Controllers;

import com.example.demo.Administrations.*;
import com.example.demo.MockAdministration.MockOrderAdministration;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/orders/")
public class OrderController {
    private OrderAdministration orderAdministration;
    private MockOrderAdministration mockOrderAdministration;
    private List<OrderDTO> orders;
    private List<AddingDTO> addings = new ArrayList<>();
    private List<CategoryDTO> categories = new ArrayList<>();

    private List<MealDTO> meals = new ArrayList<>();
@Autowired
    public OrderController(OrderAdministration orderAdministration) {
        this.orderAdministration = orderAdministration;
        CategoryDTO c1 = new CategoryDTO(1,"Pizza", "./pictures/lasagna.jpg");
        CategoryDTO c2 = new CategoryDTO(2,"Pasta", "./pictures/lasagna.jpg");
        CategoryDTO c3 = new CategoryDTO(3,"Salads", "./pictures/lasagna.jpg");
        CategoryDTO c4 = new CategoryDTO(4,"Deserts", "./pictures/lasagna.jpg");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        meals.add(new MealDTO(1, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(2, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(3, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(4, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(5, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(6, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(7, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(8, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(8, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(9, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(10, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(11, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(12, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(13, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(14, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
    meals.add(new MealDTO(15, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(16, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(17, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(18, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(19, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(20, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(21, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
    meals.add(new MealDTO(22, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(23, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(24, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(25, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(26, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(27, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    meals.add(new MealDTO(28, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
    addings.add(new AddingDTO(1, "Garlic", 50,1));
    addings.add(new AddingDTO(2, "Mushrooms", 50,1));
    addings.add(new AddingDTO(3, "Pepper", 50,1));
    addings.add(new AddingDTO(4, "Corn", 50,1));
    addings.add(new AddingDTO(5, "Mocarella", 50,1));
    addings.add(new AddingDTO(6, "Parmezan", 50,1));
}
    public OrderController(MockOrderAdministration mockOrderAdministration) {
        this.mockOrderAdministration = mockOrderAdministration;
    }
    public List<OrderDTO> GetOrders() {
        return this.orders;
    }

    @GetMapping("Addings")
    public List<AddingDTO> GetAddings() {
        return this.addings;
    }


    @GetMapping("Meals")
    public List<MealDTO> GetMeals() {
        return this.meals;
    }

    @GetMapping("Deserts")
    public List<MealDTO> GetDeserts() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : meals) {
            if(m.getCategory().getName().equals("Deserts")) {
                newList.add(m);
            }
        }
    return newList;
    }

    @GetMapping("Salads")
    public List<MealDTO> GetSalads() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : meals) {
            if(m.getCategory().getName().equals("Salads")) {
                newList.add(m);
            }
        }
        return newList;
    }

    @GetMapping("Pasta")
    public List<MealDTO> GetPasta() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : meals) {
            if(m.getCategory().getName().equals("Pasta")) {
                newList.add(m);
            }
        }
        return newList;
    }

    @GetMapping("Pizza")
    public List<MealDTO> GetPizza() {
        List<MealDTO> newList = new ArrayList<>();
        for(MealDTO m : meals) {
            if(m.getCategory().getName().equals("Pizza")) {
                newList.add(m);
            }
        }
        return newList;
    }

    @GetMapping("{id}")
    public MealDTO GetMeal(@PathVariable int id) {
    MealDTO meal = null;
        for(MealDTO m : meals) {
            if(m.getId() == id) {
                meal = m;
            }
        }
        return meal;
    }


    @GetMapping("Categories")
    public List<CategoryDTO> GetCategories() {
        return this.categories;
    }
    @GetMapping("categoryIds")
    public List<Integer> GetCategoryIds() {
        List<Integer> ids = new ArrayList<>();
        for(CategoryDTO category: categories) {
                ids.add(category.getIndex());
        }
        return ids;
    }
    @GetMapping("categoryImages")
    public List<String> GetCategoryImages() {
        List<String> images = new ArrayList<>();
        for(CategoryDTO category: categories) {
                images.add(category.getImage());
        }
        return images;
    }
    @GetMapping("categoryNames")
    public List<String> GetCategoryNames() {
        List<String> names = new ArrayList<>();
        for(CategoryDTO category: categories) {
                names.add(category.getName());
        }
        return names;
    }

    public OrderDTO GetOrder() {
        return null;
    }
}
