package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    //Attributes
    private int userId;
    private String userName;
    private List<Event> events = new ArrayList<>();
    private List<Group> groups;
    private Map<String, String> settings;
    private Notification notifications;

    //Constructor
    public User(){

    }

    //Methods
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void joinEvent(Event event) {
        this.events.add(event);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
}
