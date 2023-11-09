package src.main.classes;

import java.util.Date;
import java.util.List;

public class Event {
    //Attributes
    private User host;
    private List<User> organisators;
    private List<User> participants;
    private Chat chat;
    private String description;
    private String name;
    private Date date;

    //Constructor
    public Event(){
        chat = new Chat();

    }

    //Methods

}
