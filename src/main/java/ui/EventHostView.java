package ui;

import classes.User;
import interfaces.EventViewUI;
import classes.Event;
import interfaces.UI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EventHostView extends Application implements EventViewUI {
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


    //Demonstration
    int userCount = 0;


    //Constructor
    public EventHostView() {
        this.windowTitle = "test";
        this.user = new User();
        this.event = new Event(user, "title", "desc", "place", "date");
    }
    public EventHostView(String windowTitle, Event event, User user) {
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
                FXMLLoader loader = new FXMLLoader(EventHostView.class.getResource("operator-view.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setTitle(windowTitle);
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
                StageHelper.addStage(stage);
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
        if (dialog.getResult() != null) {
            title.setText("Title: " + dialog.getResult());
            event.setTitle(title.getText());
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
        System.out.println(dialog.getResult());
        if (dialog.getResult() != null) {
            description.setText("Description: " + dialog.getResult());
            event.setDescription(description.getText());
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
        if (dialog.getResult() != null) {
            //date.setText("Date: " + dialog.getResult());
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
        if (dialog.getResult() != null) {
            place.setText("Place: " + dialog.getResult());
            event.setPlace(place.getText());
        }
    }

    /*public void openChat() {
        EventChatView chatUI = new EventChatView(event.getTitle()+" chat", user, event.getChat());
    }*/
    @FXML
    private void openChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(EventHostView.class.getResource("chat-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 600, 400);
        stage.setTitle("chat");
        stage.setScene(scene);
        stage.show();
    }
    private User selectParticipatorUI() {
        //Getting all users and saving the usernames in a list
        List<String> participants = new ArrayList<String>();
        for (User user : event.getParticipants()) {
            participants.add(user.getUserName());
        }
        return null;
    }

        //A custom option pane which displays a button for each user.
        //On click the option pane disappears and returns an integer which corresponds to the selected user
        /*int option = JOptionPane.showOptionDialog(null, "Select user",
                ("Participants of \"" + event.getTitle() + "\""), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, participants.toArray(), participants.toArray()[0]);
        return event.getParticipants().get(option);
    }*/





    /**
     * Opens a new window showing a list of buttons. Each button represents a participator of the event.
     * On click, the method returns the selected participator
     * @return
     */
    /*else if (e.getSource()==addParticipatorButton) {
        User user = new User();
        user.setUserId(userCount);
        user.setUserName("user"+userCount);
        event.addParticipator(user);
        userCount++;
    }*/
    @FXML
    private void addParticipator(){
        User user = new User();
        user.setUserId(userCount);
        user.setUserName("user"+userCount);
        TempParticipatorHelper.addParticipator(user);
        System.out.println(TempParticipatorHelper.getParticipators());
        System.out.println(user.getUserName());
        userCount++;

        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(EventHostView.class.getResource("participator-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(user.getUserName());
            StageHelper.addStage(stage);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*else if (e.getSource()==removeParticipatorButton) {
        //Uses the Value returned from the option pane to get the specified user from the event.
        //Unless the user is the host, the selected user is removed.
        User selUser = selectParticipatorUI();
        if (selUser == event.getHost()){
            JOptionPane.showMessageDialog(null, "The host cannot be removed from the event",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            event.removeParticipator(selUser);
        }
    }*/
    @FXML
    private void removeParticipator(){
        Stage stage1 = new Stage();
        stage1.setTitle("removeParticipator");
        StageHelper.addStage(stage1);
        VBox buttons = new VBox(10);
        System.out.println(userCount);
        List<User> temp = TempParticipatorHelper.getParticipators();
        for (User user : temp){
            for (int i=0;i< temp.size();i++){
                Button button = new Button(user.getUserName());
                System.out.println(button.getText());
                System.out.println(user.getUserName());
                button.setOnAction(e -> {
                    closeStage(user.getUserName());
                    TempParticipatorHelper.removeParticipator(user);
                    closeStage(stage1.getTitle());
                    userCount--;
                });
                buttons.getChildren().add(button);
            }
        }

        Scene scene = new Scene(buttons,200,200);
        stage1.setScene(scene);
        stage1.show();
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
    @FXML
    public void closeUI(){
        Stage stage = new Stage();
        MainView mainView =  new MainView();
        closeStage(this.windowTitle);
        mainView.start(stage);
    }

    @Override
    public void setImage() {

    }

}
