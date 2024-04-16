package src.main.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import src.main.classes.Chat;
import src.main.classes.Message;
import src.main.classes.User;
import src.main.interfaces.UI;
import java.io.File;

public class EventChatView implements UI {
    //Attributes
    private Chat chat;
    private User user;
    private Image myPicture;
    private Stage stage;
    private BorderPane layout;
    private Label userLabel;
    private ImageView picView;
    private Button sendMessageButton;
    private Button closeChatButton;
    private TextArea chatArea;
    private TextField messageField;

    //Constructor
    public EventChatView(String windowTitle, User user, Chat chat){
        this.chat = chat;
        this.user = user;
        setImage();
        initUI(windowTitle);
        chat.initializeNewUI(this);
    }

    //Methods

    /**
     * Adds a string of the supplied message object to the chat TextArea, making the message and it's user appear on it
     * @param message
     */
    public void addMessage(Message message){
        this.chatArea.appendText(message.toString());
    }

    public void setImage(){
        myPicture = new Image(new File("documentation/logo/letsevent_transparent.png").toURI().toString());
        picView = new ImageView(myPicture);
        picView.setFitWidth(150);
        picView.setPreserveRatio(true);
    }

    public void closeUI(){
        stage.close();
    }

    @Override
    public void initUI(String windowTitle) {
        //Frame
        stage = new Stage();
        stage.setTitle(windowTitle);
        stage.setWidth(800);
        stage.setHeight(600);

        //Username
        userLabel = new Label(user.getUserName());
        VBox userPanel = new VBox(userLabel);
        userPanel.setBorder(new Border(new BorderStroke(javafx.scene.paint.Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        //Chat window elements
        chatArea = new TextArea();
        chatArea.setEditable(false);
        messageField = new TextField();
        HBox buttonPanel = new HBox(10);
        VBox bottomPanel = new VBox(10, messageField, buttonPanel);

        //Event Actionbuttons
        sendMessageButton = new Button("Send message");
        closeChatButton = new Button("Close chat");
        sendMessageButton.setOnAction(e -> {
            if(messageField.getText().isEmpty()){
                new Alert(Alert.AlertType.WARNING, "Enter a message").showAndWait();
            }
            else{
                chat.sendMessage(user, messageField.getText());
                messageField.setText("");
            }
        });
        closeChatButton.setOnAction(e -> closeUI());
        buttonPanel.getChildren().addAll(sendMessageButton, closeChatButton);

        //Center panel
        BorderPane centerPanel = new BorderPane();
        centerPanel.setCenter(chatArea);
        centerPanel.setBottom(bottomPanel);

        //Finalizing frame
        layout = new BorderPane();
        layout.setTop(picView);
        layout.setCenter(centerPanel);
        layout.setLeft(userPanel);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}

