package main;

import classes.DBConnector;
import javafx.application.Application;
import javafx.scene.control.Alert;
import ui.LoginView;

import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        DBConnector connector = new DBConnector("http://localhost:8080/api/");

        if(connector.reachable()){
            new Thread(() -> Application.launch(LoginView.class, args)).start();
        }

        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Connection timed out while connecting to the database");
        }



    }
}