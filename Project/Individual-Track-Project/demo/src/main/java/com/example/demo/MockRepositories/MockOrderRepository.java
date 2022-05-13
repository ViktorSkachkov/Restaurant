package com.example.demo.MockRepositories;

import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MealDTO;
import com.example.demo.dto.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockOrderRepository {
    //private MySqlConnection con;
    private List<OrderDTO> orders = new ArrayList<>();
    private List<AddingDTO> addings = new ArrayList<>();
    private List<CategoryDTO> categories = new ArrayList<>();

    private List<MealDTO> meals = new ArrayList<>();
    public MockOrderRepository() {
        CategoryDTO c1 = new CategoryDTO(1,"Pizza", "./pictures/lasagna.jpg");
        CategoryDTO c2 = new CategoryDTO(2,"Pasta", "./pictures/lasagna.jpg");
        CategoryDTO c3 = new CategoryDTO(3,"Salads", "./pictures/lasagna.jpg");
        CategoryDTO c4 = new CategoryDTO(4,"Desserts", "./pictures/lasagna.jpg");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        meals.add(new MealDTO(1, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(2, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(3, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(4, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(5, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(6, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(7, c2.getId(), "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(8, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(8, c1.getId(), "pizzaImage", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(9, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(10, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(11, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(12, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(13, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(14, c1.getId(), "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(15, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(16, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(17, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(18, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(19, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(20, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(21, c4.getId(), "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        meals.add(new MealDTO(22, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(23, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(24, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(25, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(26, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(27, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(28, c3.getId(), "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        addings.add(new AddingDTO(1, "Garlic", 50,1));
        addings.add(new AddingDTO(2, "Mushrooms", 50,1));
        addings.add(new AddingDTO(3, "Pepper", 50,1));
        addings.add(new AddingDTO(4, "Corn", 50,1));
        addings.add(new AddingDTO(5, "Mocarella", 50,1));
        addings.add(new AddingDTO(6, "Parmezan", 50,1));
    }
    public List<AddingDTO> GetAddings() {
        return addings;
    }
    public List<CategoryDTO> GetCategories() {
        return categories;
    }
    public List<MealDTO> GetMeals() {
        return meals;
    }
    public List<OrderDTO> GetOrders() {
        return orders;
    }
   /* public MySqlConnection getCon() {
        return con;
    }*/
}
