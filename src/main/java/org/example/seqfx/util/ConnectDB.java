package org.example.seqfx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private Connection connection;

    public ConnectDB() {
        String url = "jdbc:sqlite:mydb.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        } catch(SQLException e) {
            System.out.println("Error Connecting to Database");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Connection Closed");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
