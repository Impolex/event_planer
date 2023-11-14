package src.main;

import src.main.classes.Event;
import src.main.classes.User;
import src.main.ui.EventHostView;
import src.main.ui.EventParticipatorView;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("user1");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("user2");



        Event event = new Event(user1);
        event.setDate("01.01.2000, 12:00");
        event.setPlace("My basement");
        event.setDescription("I dont fucking know anymore");
        event.setTitle("Crying violently");

        EventHostView hostView = new EventHostView("Host View", event, user1);
        EventParticipatorView participatorView = new EventParticipatorView("Participator View", event, user2);

    }
}