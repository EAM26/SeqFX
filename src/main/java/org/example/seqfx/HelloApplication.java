package org.example.seqfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.seqfx.controller.SequenceController;
import org.example.seqfx.controller.ViewController;
import org.example.seqfx.model.Sequence;
import org.example.seqfx.model.View;
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
        ViewController viewCon = new ViewController();

//        TESTING CRUD METHODS
//        ADD sequence
        seqCon.createSequence("firstSequence");
        seqCon.createSequence("secondSequence");
        seqCon.createSequence("thirdSequence");
//        Delete sequence
        seqCon.deleteSequence(1L);
//        Get sequence
        Sequence seq = seqCon.getSequence(2L);
        System.out.println(seq.getId());
        System.out.println(seq.getName());
//        Update sequence
        seqCon.updateSequence(2L, "Updated Sequence");
//        Get all sequences
        List<Sequence> allSequences = seqCon.getAllSequences();
        for(Sequence sequence: allSequences) {
            System.out.println(sequence.getId() + ": " + sequence.getName());
        }
//        Create view
        System.out.println(viewCon.createView("cam-1", 2L));
//        System.out.println(viewCon.createView("cam-1", 100L));

//        Get view
        View testView = viewCon.getView(2L);
        System.out.println("testView name: " + testView.getName());
        System.out.println("testView sequence name: " + testView.getSequence().getName());

//        Get all views
        List<View> views = viewCon.getAllViews();
        for(View view: views) {
            System.out.println(view.getName());
        }








//        launch();
    }

   public void stop() throws Exception {
        ConnectDB.closeConnection();
        super.stop();
    }
}