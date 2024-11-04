package org.example.seqfx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializer(Connection connection) {
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS views (id INTEGER PRIMARY KEY, name TEXT)";
                statement.executeUpdate(createTable);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
