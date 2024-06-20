package ui;

import classes.User;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TempParticipatorHelper {
    private static List<User> addedParticipators = new ArrayList<>();

    public static void addParticipator(User user){
        addedParticipators.add(user);
    }
    public static void removeParticipator(User user){
        addedParticipators.remove(user);
    }

    public static List<User> getParticipators(){
        return new ArrayList<>(addedParticipators);
    }

}