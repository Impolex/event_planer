package ui;

import classes.Chat;
import classes.Message;
import classes.User;
import interfaces.UI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EventChatView extends Application implements UI{
    //Attributes
    private Chat chat;
    private User user;
    private String windowTitle;


    //Constructor
    public EventChatView(String windowTitle, User user, Chat chat){
        this.chat = chat;
        this.user = user;
        this.windowTitle=windowTitle;
        chat.initializeNewUI(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(EventChatView.class.getResource("chat-view.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.show();
    }
    //Methods

    /**
     * Adds a string of the supplied message object to the chat TextArea, making the message and it's user appear on it
     * @param message
     */
    public void addMessage(Message message){

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
