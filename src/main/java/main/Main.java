package main;

import classes.Event;
import classes.User;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.EventHostView;
import ui.MainView;


public class Main{


    public static void main(String[] args) {
        new Thread(() -> Application.launch(MainView.class, args)).start();
    }
}