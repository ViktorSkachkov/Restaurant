package com.example.demo.Repositories;

import com.example.demo.dto.*;
import org.springframework.stereotype.Repository;
import java.sql.*;

import java.util.*;

@Repository
public class UserRepository {
   // public MySqlConnection con;
    private List<UserDTO> users = new ArrayList<>();
    private ConnectionClass Con = new ConnectionClass();
    public UserRepository() {
        /*users.add(new ClientDTO(1,"Viktor", "Skachkov", "dragonslayer",
                "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785", false));
        users.add(new ClientDTO(2,"Pavel", "Dimitrov", "bomber",
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
                "TheKingBeyond", "katrin.jonathan@gmail.com", "Pieter Breughelstraat 19", "743578967543434", false));*/
    this.ConnectMethod();
    }

    public void ConnectMethod() {
        try {
            Statement statement = Con.GetConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while(resultSet.next()) {
                users.add(new ClientDTO(resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"),
                        resultSet.getString("username"), resultSet.getString("pwd"), resultSet.getString("email"),
                        resultSet.getString("address"), resultSet.getString("phone"), false, ""));
            }
        }
        catch (Exception ex) {
           ex.printStackTrace();
        }

    }
    public List<UserDTO> GetUsers() {
        return users;
    }
}
