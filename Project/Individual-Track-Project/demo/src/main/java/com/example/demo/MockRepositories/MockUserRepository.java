package com.example.demo.MockRepositories;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.WorkerDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockUserRepository {
    //public MySqlConnection con;
    private List<UserDTO> users = new ArrayList<>();
    public MockUserRepository() {
        /*users.add(new UserDTO(1,"Viktor", "Skachkov", "dragonslayer",
                "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785", false, ""));
        users.add(new UserDTO(2,"Pavel", "dimitrov", "bomber",
                "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745", false, ""));
        users.add(new UserDTO(3,"Todor", "Petrov", "kalipso",
                "manhattan", "todor.petrov@gmail.com", "Pieter Breughelstraat 19", "65789809087645", false, ""));
        users.add(new UserDTO(4,"Martin", "Yordanov", "lampofthegenie",
                "Waaargh", "martin.yordanov@gmail.com", "Pieter Breughelstraat 19", "67893424545636", false, ""));
        users.add(new UserDTO(5,"Radostin", "Martinov", "qyburn",
                "uhata", "radostin.martinov@gmail.com", "Pieter Breughelstraat 19", "87964356567645", false, ""));
        users.add(new UserDTO(6,"Wat", "Tambor", "StarWars",
                "starcraft", "Wat.Tambor@gmail.com", "Pieter Breughelstraat 19", "11143565784554", false, ""));
        users.add(new UserDTO(7,"Sarah", "Kerrigan", "queenOfBlades",
                "zergQueen", "sarah.kerrigan@gmail.com", "Pieter Breughelstraat 19", "234564677886565", false, ""));
        users.add(new UserDTO(8,"John", "Arryn", "asoiaf",
                "eagleSigil", "john.arryn@gmail.com", "Pieter Breughelstraat 19", "335457689897645", false, ""));
        users.add(new UserDTO(9,"Katrin", "Jonathan", "romani",
                "TheKingBeyond", "katrin.jonathan@gmail.com", "Pieter Breughelstraat 19", "743578967543434", false, ""));*/
    }

    public List<UserDTO> GetUsers() {
        return users;
    }
}
