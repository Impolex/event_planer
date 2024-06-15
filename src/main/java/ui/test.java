package ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class test extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(test.class.getResource("operator-view.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setTitle("test");
        stage.setScene(scene);
        stage.show();
    }
}
