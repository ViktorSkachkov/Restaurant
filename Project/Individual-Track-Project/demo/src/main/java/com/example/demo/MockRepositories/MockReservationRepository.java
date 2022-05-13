package com.example.demo.MockRepositories;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.TableItemDTO;
import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockReservationRepository {
   // private MySqlConnection con;
   private List<TableItemDTO> tables = new ArrayList<>();
    private List<ReservationRequestDTO> reservationRequests = new ArrayList<>();
  /*  UserDTO client1 = new UserDTO(1,"Viktor","Skachkov", "dragonslayer",
            "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785", false, "");
    UserDTO client2 = new UserDTO(2,"Pavel","dimitrov", "bomber",
            "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745", false, "");*/
    public MockReservationRepository() {
        /*tables.add(new TableItemDTO(1,4,"Outside"));
        tables.add(new TableItemDTO(2,4,"Outside"));
        tables.add(new TableItemDTO(3,2,"Outside"));
        tables.add(new TableItemDTO(4,2,"Outside"));
        tables.add(new TableItemDTO(5,2,"Inside"));
        tables.add(new TableItemDTO(6,2,"Inside"));
        tables.add(new TableItemDTO(7,4,"Inside"));
        tables.add(new TableItemDTO(8,4,"Inside"));
        tables.add(new TableItemDTO(9,2,"Inside"));
        tables.add(new TableItemDTO(10,2,"Inside"));
        reservationRequests.add(new ReservationRequestDTO(1, client1.getId(),
                "I would like to be outside", 3, 16, "false"));
        reservationRequests.add(new ReservationRequestDTO(2, client1.getId(),
                "I would like to be inside", 2, 19, "false"));
        reservationRequests.add(new ReservationRequestDTO(3, client2.getId(),
                "I would like to be outside", 4, 14, "false"));
        reservationRequests.add(new ReservationRequestDTO(4, client2.getId(),
                "I would like to be inside", 1, 20, "false"));*/
    }
    public List<TableItemDTO> GetTables() {
        return tables;
    }
    public List<ReservationRequestDTO> GetReservationRequests() {
        return reservationRequests;
    }
    /*public MySqlConnection getCon() {
        return con;
    }*/
}
