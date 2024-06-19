package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;

import java.util.List;

public class MainView extends Application{
    @FXML
    private AnchorPane newEvent;
    @FXML
    private AnchorPane content;
    @FXML
    private Label Account;
    public MainView(){

    }
    public void initialize(){
        try {
            FXMLLoader loader2 = new FXMLLoader(MainView.class.getResource("eventspage-view.fxml"));
            Parent parent2 = loader2.load();
            content.getChildren().add(parent2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(MainView.class.getResource("main-view.fxml"));
            Parent root = loader.load();
            MainView controller = loader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            controller.setFullScreen(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFullScreen(Stage stage){
        stage.setFullScreen(true);
    }



    public void createNewEvent() throws Exception{
        try{
            FXMLLoader loader = new FXMLLoader(MainView.class.getResource("operator-view.fxml"));
            Parent root = loader.load();
            content.getChildren().removeAll();
            content.getChildren().addAll(root);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
