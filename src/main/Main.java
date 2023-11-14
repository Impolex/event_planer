package src.main;

import src.main.classes.Event;
import src.main.classes.User;


public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("user1");

        Event event = new Event(user1, "Crying violently", "I dont fucking know anymore",
                "My basement", "01.01.2000, 12:00");
    }
}