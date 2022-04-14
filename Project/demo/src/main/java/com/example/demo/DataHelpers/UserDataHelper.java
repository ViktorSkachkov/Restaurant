package com.example.demo.DataHelpers;

import com.example.demo.dto.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDataHelper {
   // public MySqlConnection con;
    private List<UserDTO> users = new ArrayList<>();
    public UserDataHelper() {
        UserDTO user1 = new UserDTO(1, "Viktor", "Skachkov",
                "viktor.sk", "viktor.sk", "viktor.skachkov01@gmail.com",
                "vrtjylyj", "5678453");
        users.add(user1);
    }
    /*public MySqlConnection getUserConnection() {
        return this.con;
    }*/

    public List<UserDTO> getUsers() {
        return users;
    }
}
