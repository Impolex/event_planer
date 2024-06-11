package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class test extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("eventspage-view.fxml"));
        stage.setScene(new Scene(loader, 600, 400));
        stage.show();
    }
}
