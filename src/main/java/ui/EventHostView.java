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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class EventHostView extends Application implements UI {
    //Attributes
    private User user;
    private Event event;
    private String windowTitle;
    int participators;

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label place;
    @FXML
    private Label date;



    //Demonstration
    int userCount = 2;

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(EventHostView.class.getResource("operator-view" +
                ".fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.show();
    }

    //Constructor
    public EventHostView(String windowTitle, Event event, User user){
        this.user = user;
        this.event = event;
        this.windowTitle = windowTitle;
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

    /*public void openChat() {
        EventChatView chatUI = new EventChatView(event.getTitle()+" chat", user, event.getChat());
    }*/
    @FXML
    private void openChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(EventHostView.class.getResource("chat-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(),600,400);
        stage.setTitle("chat");
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Opens a new window showing a list of buttons. Each button represents a participator of the event.
     * On click, the method returns the selected participator
     * @return
     */
    @FXML
    private void removeParticipator(){
        Stage stage = new Stage();
        VBox buttons = new VBox(10);
        for (int i=0;i<participators;i++){
            Button button = new Button("Participator"+i);
            System.out.println(button.getText());
            button.setOnAction(e -> closeStage(button.getText()));
            buttons.getChildren().add(button);
        }
        Scene scene = new Scene(buttons,200,200);
        stage.setScene(scene);
        stage.show();
    }
    private void closeStage(String stageName){
        for(Stage stage : StageHelper.getStages()){
            if (stage.getTitle().equals(stageName)) {
                stage.close();
            }
        }

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
