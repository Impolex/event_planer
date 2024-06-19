package ui;

import classes.User;
import interfaces.EventViewUI;
import classes.Event;
import interfaces.UI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EventParticipatorView extends Application implements EventViewUI {
    //Attributes
    private User user;
    private Event event;
    private String windowTitle;

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label place;
    @FXML
    private Label date;
    @FXML
    private Label host;

    //Constructor
    public EventParticipatorView() {
        this.windowTitle = "Window Title";
        this.user = new User();
        this.event = new Event(user, "title", "desc", "place", "date");
    }
    public EventParticipatorView(String windowTitle, Event event, User user) {
        this.windowTitle=windowTitle;
        this.event=event;
        this.user=user;
    }


    public void init(String[] args) {
        Platform.runLater(() -> {
            Application.launch(args);
        });
    }

    @Override
    public void start(Stage stage) {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(EventParticipatorView.class.getResource("participator-view.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setTitle(windowTitle);
                stage.setScene(scene);
                StageHelper.addStage(stage);
                stage.sizeToScene();
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


    //Methods

    /**
     * Reads the event title, sets it as the labels new text and repaints the label
     */
    /*public void repaintTitleLabel(){
        titleLabel.setText("Title: "+event.getTitle());
        this.titleLabel.repaint();
    }*/
    @FXML
    public void repaintTitleLabel() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Insert new event title");
        dialog.showAndWait();
        if(dialog.getResult()!=null){
            title.setText("Title: "+dialog.getResult());
        }
    }
    /**
     * Reads the event description, sets it as the labels new text and repaints the label
     */
    /*public void repaintDescriptionLabel(){
        descriptionLabel.setText("Description: "+event.getDescription());
        this.descriptionLabel.repaint();
    }*/
    @FXML
    public void repaintDescriptionLabel() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Insert new event description");
        dialog.showAndWait();
        if(dialog.getResult()!=null) {
            description.setText("Description: " + dialog.getResult());
        }
    }

    /**
     * Reads the event date, sets it as the labels new text and repaints the label
     */
    /*public void repaintDateLabel(){
        this.dateLabel.setText("Date: "+event.getDate());
        this.dateLabel.repaint();
    }*/
    @FXML
    public void repaintDateLabel() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Insert new date");
        dialog.showAndWait();
        if(dialog.getResult()!=null) {
            date.setText("Date: " + dialog.getResult());
        }
    }

    /**
     * Reads the event place, sets it as the labels new text and repaints the label
     */
    /*public void repaintPlaceLabel(){
        this.placeLabel.setText("Place: "+event.getPlace());
        this.placeLabel.repaint();
    }*/
    @FXML
    public void repaintPlaceLabel() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Insert new place");
        dialog.showAndWait();
        if(dialog.getResult()!=null) {
            place.setText("Place: " + dialog.getResult());
        }
    }

    public void openChat() {

    }


    @Override
    public void initUI(String windowTitle) {

    }

    public void closeUI(){
        Platform.exit();
    }

    @Override
    public void setImage() {

    }


}
