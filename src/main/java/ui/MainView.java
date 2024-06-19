package ui;

import classes.Event;
import classes.User;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application{
    @FXML
    private AnchorPane newEvent;
    @FXML
    private AnchorPane content;
    @FXML
    private Label Account;
    @FXML
    private ListView<Event> listView;
    @FXML
    private ObservableList<Event> observableList = FXCollections.observableArrayList();


    public MainView(){

    }
    public void initialize(){
        User user = new User();
        ObservableList<Event> observableList = FXCollections.observableArrayList();
        observableList.add(new Event(user,"title","desc","place","date"));
        listView.setCellFactory(lv -> new ListCell<Event>() {
            @Override
            protected void updateItem(Event event, boolean empty) {
                super.updateItem(event, empty);
                setText(empty ? null : event.getTitle());
            }
        });
        listView.setItems(observableList);
        try {
            content.getChildren().clear();
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
            content.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(MainView.class.getResource("operator-view.fxml"));
            Parent root = loader.load();
            content.getChildren().addAll(root);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
