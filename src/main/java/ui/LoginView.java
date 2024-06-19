package ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Application {


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
}
