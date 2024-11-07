package org.example.seqfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.seqfx.controller.SequenceController;
import org.example.seqfx.model.Sequence;
import org.example.seqfx.util.ConnectDB;
import org.example.seqfx.util.DatabaseInitializer;

import java.io.IOException;
import java.util.List;


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
//        Move DB initializer to start method when app is finished
        DatabaseInitializer.initializer(ConnectDB.getConnection());

        SequenceController seqCon = new SequenceController();
//        TESTING CRUD METHODS
//        ADD sequence
        seqCon.addSequence("testSequence2");
//        Delete sequence
        seqCon.deleteSequence(1L);
//        Get sequence
        Sequence seq = seqCon.getSequence(5L);
        System.out.println(seq.getId());
        System.out.println(seq.getName());
//        Update sequence
        seqCon.updateSequence(99L, "Updated Sequence");
//        Get all sequences
        List<Sequence> allSequences = seqCon.getAllSequences();
        for(Sequence sequence: allSequences) {
            System.out.println(sequence.getId() + ": " + sequence.getName());
        }





//        launch();
    }

   public void stop() throws Exception {
        ConnectDB.closeConnection();
        super.stop();
    }
}