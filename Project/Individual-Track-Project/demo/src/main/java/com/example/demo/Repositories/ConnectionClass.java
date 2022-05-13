package com.example.demo.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection GetConnection() {
        Connection connection = null;
        try {
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "ultralisk66");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
