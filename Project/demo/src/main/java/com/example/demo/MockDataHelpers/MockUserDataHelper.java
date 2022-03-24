package com.example.demo.MockDataHelpers;

import com.example.demo.Normal.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDataHelper {
    //public MySqlConnection con;
    private List<User> users = new ArrayList<>();
    public MockUserDataHelper() {
        User user1 = new User("Viktor", "Skachkov",
                "viktor.sk", "viktor.sk", "viktor.skachkov01@gmail.com",
                "vrtjylyj", "5678453");
        users.add(user1);
    }
    /*public MySqlConnection getUserConnection() {
        return this.con;
    }*/

    public List<User> getUsers() {
        return users;
    }
}
