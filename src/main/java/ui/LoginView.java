package ui;

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

public class LoginView extends Application {

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;


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
        //Log in to Account
        MainView mainView = new MainView();
        mainView.start(new Stage());
        this.closeStage("Login");
    }

    public void closeStage(String stageName){
        for(Stage stage:StageHelper.getStages()){
            if (stage.getTitle().equals(stageName)){
                stage.close();
            }
        }
    }
    @FXML
    public void createAccount(){
        String code = password.getText();
        String name = username.getText();
        if(code.isEmpty()||name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Username or Password is missing");
        } else {
            //create Account
        }
    }
}
