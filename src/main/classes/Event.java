package src.main.classes;

import java.util.ArrayList;
import java.util.List;

public class Event {
    //Attributes
    private User host;
    private List<User> organisators;
    private List<User> participants = new ArrayList<>();
    private Chat chat;
    private String title;
    private String description;
    private String date;
    private String place;

    //Constructor
    public Event(User host){
        chat = new Chat();
        this.participants.add(host);
        this.host = host;
    }

    //Methods
    public User getHost() {
        return host;
    }

    public List<User> getOrganisators() {
        return organisators;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Chat getChat() {
        return chat;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    //Participant methods

    //Organiser methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    //Host methods
    /**
     * Gives the host status to another user, removing this status from the current host.
     * Checks if the user calling this method is the host, as this action can only be completed by the host.
     * @param currentUser
     * @param newHost
     */
    public void newHost(User currentUser, User newHost) {
        if(currentUser!=getHost()){
            System.out.println("The User "+currentUser+" cannot complete this action");
        }
        else if(getHost()==newHost){
            System.out.println("User "+newHost+" is already hosting this Event");
        }
        else{
            host = newHost;
        }
    }
}
