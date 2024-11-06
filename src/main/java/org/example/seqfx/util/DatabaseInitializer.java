package org.example.seqfx.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializer(Connection connection) {
        if(connection != null) {
            setupSequenceTable(connection);
            setupViewsTable(connection);
            setupSceneTable(connection);
        }
    }

    private static void setupSequenceTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS sequences (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT)";
            statement.executeUpdate(createTable);
            System.out.println("Sequence Table Created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setupViewsTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS views (id INTEGER PRIMARY KEY, name TEXT, " +
                    "sequence_id INTEGER, FOREIGN KEY (sequence_id) REFERENCES sequences(id))";
            statement.executeUpdate(createTable);
            System.out.println("View Table Created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setupSceneTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS scenes (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT, " +
                    "view_id INTEGER, " +
                    "sequence_id INTEGER, " +
                    "FOREIGN KEY (view_id) REFERENCES views(id), " +
                    "FOREIGN KEY (sequence_id) REFERENCES sequences(id)" +
                    ")";
            statement.executeUpdate(createTable);
            System.out.println("Scene Table Created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
