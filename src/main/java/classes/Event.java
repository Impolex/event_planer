package classes;


import interfaces.EventViewUI;
import ui.EventHostView;
import ui.EventParticipatorView;

import java.util.ArrayList;
import java.util.List;

public class Event {
    //Attributes
    private User host;
    private List<User> organisators = new ArrayList<>();
    private List<EventMember> participants = new ArrayList<>();
    private Chat chat;
    private String title;
    private String description;
    private String date;
    private String place;
    private ArrayList<EventViewUI> UIs = new ArrayList<>();

    //Constructor
    public Event(User host, String title, String description, String place, String date){
        this.chat = new Chat();
        this.title = title;
        this.description = description;
        this.place = place;
        this.date = date;
        chat = new Chat();
        //this.participants.add(host);
        this.organisators.add(host);
        this.host = host;
        EventHostView hostView = new EventHostView("Host View", this, host);
        UIs.add(hostView);
    }

    //Methods
    public User getHost() {
        return host;
    }


    public List<User> getOrganisators() {
        return organisators;
    }

    public List<EventMember> getParticipants() {
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

    public List<EventViewUI> getUIs(){
        return UIs;
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

    /**
     * Adds the specified user to the participants list, opens a participator view UI and adds the UI to the UIs list.
     * @param user The user instance to be added
     */
    public void addParticipator(User user){
        //participants.add(user);
        EventParticipatorView participatorView1 = new EventParticipatorView("Participator View",this, user);
        UIs.add(participatorView1);
    }

    /**
     * Closes the UI of the specified user, removes the UI from the UIs list and removes the user from the participants list.
     * @param user The user instance to be removed
     */
    public void removeParticipator(User user) {
        UIs.get(participants.indexOf(user)).closeUI();
        UIs.remove(participants.indexOf(user));
        participants.remove(user);
    }
    //Host methods
    /**
     * Gives the host status to another user, removing this status from the current host.
     * Checks if the user calling this method is the host, as this action can only be completed by the host.
     * @param currentUser The user instance calling this method
     * @param newHost The user instance to be given host status
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
