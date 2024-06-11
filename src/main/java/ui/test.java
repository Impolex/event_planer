package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class test extends Application {
    public test() throws IOException {
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
    FXMLLoader loader = FXMLLoader.load(getClass().getResource("eventspage-view.fxml"));

}
