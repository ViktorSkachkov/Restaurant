package com.example.demo.Repositories;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ReservationRequestDTO;
import com.example.demo.dto.TableItemDTO;
import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {
    //private MySqlConnection con;
    private List<TableItemDTO> tables = new ArrayList<>();
    private List<ReservationRequestDTO> reservationRequests = new ArrayList<>();
    private List<UserDTO> users = new ArrayList<>();
    private ConnectionClass Con = new ConnectionClass();
    /*UserDTO client1 = new ClientDTO(1,"Viktor","Skachkov", "dragonslayer",
            "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785", false);
    UserDTO client2 = new ClientDTO(2,"Pavel","dimitrov", "bomber",
            "Jackal", "pavel.dimitrov01@gmail.com", "Pieter Breughelstraat 19", "43554373753745", false);*/
    public ReservationRepository() {
        /*tables.add(new TableItemDTO(1,4,"Outside"));
        tables.add(new TableItemDTO(2,4,"Outside"));
        tables.add(new TableItemDTO(3,2,"Outside"));
        tables.add(new TableItemDTO(4,2,"Outside"));
        tables.add(new TableItemDTO(5,2,"Inside"));
        tables.add(new TableItemDTO(6,2,"Inside"));
        tables.add(new TableItemDTO(7,4,"Inside"));
        tables.add(new TableItemDTO(8,4,"Inside"));
        tables.add(new TableItemDTO(9,2,"Inside"));
        tables.add(new TableItemDTO(10,2,"Inside"));*/
        /*reservationRequests.add(new ReservationRequestDTO(1, client1, null,
                "I would like to be outside", 3, 16, false));
        reservationRequests.add(new ReservationRequestDTO(2, client1, null,
                "I would like to be inside", 2, 19, false));
        reservationRequests.add(new ReservationRequestDTO(3, client2, null,
                "I would like to be outside", 4, 14, false));
        reservationRequests.add(new ReservationRequestDTO(4, client2, null,
                "I would like to be inside", 1, 20, false));*/
        this.ConnectMethod();
    }
    public void ConnectMethod() {
       /* try {
            Statement statement = Con.GetConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from table");
            while(resultSet.next()) {
                tables.add(new TableItemDTO(resultSet.getInt("id"), resultSet.getInt("seats"), resultSet.getString("location")));
            }
            Statement statement2 = Con.GetConnection().createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select * from user");
            while(resultSet2.next()) {
                users.add(new ClientDTO(resultSet2.getInt("id"), resultSet2.getString("first_name"), resultSet2.getString("last_name"),
                        resultSet2.getString("username"), resultSet2.getString("pwd"), resultSet2.getString("email"),
                        resultSet2.getString("address"), resultSet2.getString("phone"), false, ""));
            }
            Statement statement3 = Con.GetConnection().createStatement();
            ResultSet resultSet3 = statement.executeQuery("select * from reservation_request");
            while(resultSet3.next()) {
                reservationRequests.add(new ReservationRequestDTO(resultSet3.getInt("id"), resultSet3.getInt("clientId"),
                        /*null,*/ //resultSet3.getString("preferences"), resultSet3.getInt("numberOfPeople"),
             /*          resultSet3.getInt("timeHour"), "false"));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }*/

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
