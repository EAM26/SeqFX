package org.example.seqfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.seqfx.controller.SequenceController;
import org.example.seqfx.util.ConnectDB;
import org.example.seqfx.util.DatabaseInitializer;

import java.io.IOException;
import java.sql.Connection;


public class HelloApplication extends Application {


    public static ConnectDB connectDB;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        connectDB = new ConnectDB();
        DatabaseInitializer.initializer(connectDB.getConnection());
        SequenceController seqCon = new SequenceController();
        seqCon.createSequence("testSequence");


//        launch();
    }

    public static Connection getConnection() {
        return connectDB.getConnection();
    }
}