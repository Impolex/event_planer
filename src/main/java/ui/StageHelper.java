package ui;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class StageHelper {
    private static List<Stage> openStages = new ArrayList<>();

    public static void addStage(Stage stageName){
        openStages.add(stageName);
        stageName.setOnHidden(event -> openStages.remove(stageName));
    }

    public static List<Stage> getStages(){
        return new ArrayList<>(openStages);
    }

    public static void openChat(){

    }
}
