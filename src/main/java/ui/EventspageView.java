package ui;

import classes.Event;
import classes.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EventspageView extends Application {
    @FXML
    private TableView<Event> meineTableView;

    @FXML
    private TableColumn<Event, String> statusColumn;
    @FXML
    private TableColumn<Event, String> nameColumn;
    @FXML
    private TableColumn<Event, String> descriptionColumn;
    @FXML
    private TableColumn<Event, String> dateColumn;
    @FXML
    private TableColumn<Event, String> placeColumn;
    @FXML
    private TableColumn<Event, String> participantsColumn;

    @FXML
    private TableColumn<Event, String> organizerColumn;
    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(EventspageView.class.getResource("eventspage-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            StageHelper.addStage(stage);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void initialize(){
        User user1 = new User();
        ObservableList<Event> eventlist = FXCollections.observableArrayList(
            new Event(user1,"StuV-Sitzung","Es gibt Pizza und Bier, komm in die Gruppe","DHBW Karlsruhe","20.06.2024"),
            new Event(user1, "SE-Präsi","Innere Schmerzen ohne Ende","Raum 264","20.06.2024")
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        participantsColumn.setCellValueFactory(new PropertyValueFactory<>("participants"));
        organizerColumn.setCellValueFactory(new PropertyValueFactory<>("host"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        meineTableView.setItems(eventlist);
    }
}
