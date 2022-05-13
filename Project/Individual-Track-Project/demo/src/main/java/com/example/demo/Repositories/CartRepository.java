package com.example.demo.Repositories;

import com.example.demo.MockServices.MockCartService;
import com.example.demo.dto.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {
    //private MySqlConnection con;

    private MockCartService mockCartAdministration;
    private List<AddingDTO> addings = new ArrayList<>();
    List<UserDTO> users = new ArrayList<>();
    private List<CategoryDTO> categories = new ArrayList<>();

    private List<MealDTO> meals = new ArrayList<>();
    private ConnectionClass Con = new ConnectionClass();
    private List<OrderedMealDTO> orderedMeals = new ArrayList<>();
    public CartRepository() {
        /*addings.add(new AddingDTO(1, "Garlic", 50,1));
        addings.add(new AddingDTO(2, "Mushrooms", 50,1));
        addings.add(new AddingDTO(3, "Pepper", 50,1));
        addings.add(new AddingDTO(4, "Corn", 50,1));
        addings.add(new AddingDTO(5, "Mocarella", 50,1));
        addings.add(new AddingDTO(6, "Parmezan", 50,1));
        CategoryDTO c1 = new CategoryDTO(1,"Pizza", "./pictures/lasagna.jpg");
        CategoryDTO c2 = new CategoryDTO(2,"Pasta", "./pictures/lasagna.jpg");
        CategoryDTO c3 = new CategoryDTO(3,"Salads", "./pictures/lasagna.jpg");
        CategoryDTO c4 = new CategoryDTO(4,"Deserts", "./pictures/lasagna.jpg");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        users.add(new ClientDTO(1,"Viktor", "Skachkov", "dragonslayer",
                "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785", false));
        users.add(new ClientDTO(2,"Pavel", "dimitrov", "bomber",
                "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745", false));
        users.add(new ClientDTO(3,"Todor", "Petrov", "kalipso",
                "manhattan", "todor.petrov@gmail.com", "Pieter Breughelstraat 19", "65789809087645", false));
        users.add(new ClientDTO(4,"Martin", "Yordanov", "lampofthegenie",
                "Waaargh", "martin.yordanov@gmail.com", "Pieter Breughelstraat 19", "67893424545636", false));
        users.add(new ClientDTO(5,"Radostin", "Martinov", "qyburn",
                "uhata", "radostin.martinov@gmail.com", "Pieter Breughelstraat 19", "87964356567645", false));
        users.add(new ClientDTO(6,"Wat", "Tambor", "StarWars",
                "starcraft", "Wat.Tambor@gmail.com", "Pieter Breughelstraat 19", "11143565784554", false));
        users.add(new WorkerDTO(7,"Sarah", "Kerrigan", "queenOfBlades",
                "zergQueen", "sarah.kerrigan@gmail.com", "Pieter Breughelstraat 19", "234564677886565", false));
        users.add(new WorkerDTO(8,"John", "Arryn", "asoiaf",
                "eagleSigil", "john.arryn@gmail.com", "Pieter Breughelstraat 19", "335457689897645", false));
        users.add(new WorkerDTO(9,"Katrin", "Jonathan", "romani",
                "TheKingBeyond", "katrin.jonathan@gmail.com", "Pieter Breughelstraat 19", "743578967543434", false));
        meals.add(new MealDTO(1, c2, "/pictures/lasagna.jpg", "Lasagna",
                "tomatoes, beef, parmesan, mozzarella, onion, garlic, parsley, oregano, bell pepper", 400, 8.99));
        meals.add(new MealDTO(2, c1, "pictures/margherita.jpg", "Margherita", "crushed San Marzano tomato sauce, mozzarella, basil, olive oil", 450, 5.99));
        meals.add(new MealDTO(3, c3, "pictures/Caesar.jpg", "Caesar", "olive oil, garlic, baguette, lemon juice, Parmesan, anchovies, eggs, romaine lettuce, fried chicken", 350, 6.99));
        meals.add(new MealDTO(4, c4, "pictures/piePumpkin.jpg", "Pumpkin pie", "pumpkin, sugar, eggs, cinnamon, ginger, heavy cream", 250, 3.99));
        List<AddingDTO> addings2 = new ArrayList<>();
        addings2.add(addings.get(1));
        orderedMeals.add(new OrderedMealDTO(1, users.get(1), meals.get(1), addings2, 6.99));
        orderedMeals.add(new OrderedMealDTO(2, users.get(1), meals.get(1), addings2, 6.99));*/


        /*ConnectMethod();*/
    }
    public void ConnectMethod() {
        try {
            Statement statement = Con.GetConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category");
            while(resultSet.next()) {
                categories.add(new CategoryDTO(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image")));
            }
            Statement statement2 = Con.GetConnection().createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select * from meal");
            while(resultSet2.next()) {
                meals.add(new MealDTO(resultSet2.getInt("id"), resultSet2.getInt("category") , resultSet2.getString("image"),resultSet2.getString("name"), resultSet2.getString("description"),
                        resultSet2.getDouble("weight"), resultSet2.getDouble("price")));
            }
            Statement statement3 = Con.GetConnection().createStatement();
            ResultSet resultSet3 = statement3.executeQuery("select * from adding");
            while(resultSet3.next()) {
                addings.add(new AddingDTO(resultSet3.getInt("id"), resultSet3.getString("name"),
                        resultSet3.getDouble("weight"), resultSet3.getDouble("price")));
            }
            Statement statement4 = Con.GetConnection().createStatement();
            ResultSet resultSet4 = statement4.executeQuery("select * from user");
            while(resultSet4.next()) {
                /*users.add(new ClientDTO(resultSet4.getInt("id"), resultSet4.getString("first_name"), resultSet4.getString("last_name"),
                        resultSet4.getString("username"), resultSet4.getString("pwd"), resultSet4.getString("email"),
                        resultSet4.getString("address"), resultSet4.getString("phone"), false, ""));*/
            }
            Statement statement5 = Con.GetConnection().createStatement();
            ResultSet resultSet5 = statement5.executeQuery("select * from orderedmeal");
           /* while(resultSet5.next()) {
                List<AddingDTO> addings1 = new ArrayList<>();
                addings1.add(addings.get(resultSet5.getInt("addingId") - 1));
                double totalPrice = addings.get(resultSet5.getInt("addingId") - 1).getPrice() + meals.get(resultSet5.getInt("mealId") - 1).getPrice();
                orderedMeals.add(new OrderedMealDTO(resultSet5.getInt("id"), users.get(resultSet5.getInt("clientId") - 1),
                        meals.get(resultSet5.getInt("mealId") - 1), addings1, totalPrice));
            }*/
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public List<AddingDTO> GetAddings() {
        return addings;
    }
    public List<CategoryDTO> GetCategories() {
        return categories;
    }
    public List<UserDTO> GetUsers() {
        return users;
    }
    public List<MealDTO> GetMeals() {
        return meals;
    }
    public List<OrderedMealDTO> GetOrderedMeals() {
        return orderedMeals;
    }
    /*public MySqlConnection getCon() {
        return con;
    }*/
}
