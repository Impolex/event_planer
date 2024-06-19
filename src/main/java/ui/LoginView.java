package ui;

import classes.DBConnector;
import classes.User;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class LoginView extends Application {

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    DBConnector connector = new DBConnector("http://localhost:8080/api/");


    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(LoginView.class.getResource("login-page.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Login");
            StageHelper.addStage(stage);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loggedIn() throws Exception {

        String code = password.getText();
        String name = username.getText();
        if(code.isEmpty()||name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Username or Password is missing");
            alert.showAndWait();
        } else {
            if(connector.login(username.getText(), password.getText())){
                MainView mainView = new MainView(connector);
                mainView.start(new Stage());
                this.closeStage("Login");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An error occurred while logging in");
                alert.showAndWait();
            }
        }
    }

    public void closeStage(String stageName){
        for(Stage stage:StageHelper.getStages()){
            if (stage.getTitle().equals(stageName)){
                stage.close();
            }
        }
    }
    @FXML
    public void createAccount() throws Exception {
        String code = password.getText();
        String name = username.getText();
        if(code.isEmpty()||name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Username or Password is missing");
            alert.showAndWait();
        } else {
            if(connector.signUp(username.getText(), password.getText())){
                MainView mainView = new MainView(connector);
                mainView.start(new Stage());
                this.closeStage("Login");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An error occurred while signing up");
                alert.showAndWait();
            }
        }
    }
}
