package org.example.seqfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ConnectDB connectDB = new ConnectDB();
        Connection connection = connectDB.getConnection();

        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS views (id INTEGER PRIMARY KEY, name TEXT)";
                statement.executeUpdate(createTable);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        launch();
    }
}