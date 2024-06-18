package com.example.letseventdemo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<EventMember> events = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<GroupMember> groups = new ArrayList<>();
    /*private Map<String, String> settings;
    private Notification notifications;*/

    //Constructor
    public User(){

    }

    public User(String username, String hash, String salt) {
        this.userName = username;
        this.password = hash;
        this.salt = salt;
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

    public List<EventMember> getEvents() {
        return events;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void joinEvent(EventMember event) {
        this.events.add(event);
    }

    /*public List<Group> getGroups() {
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
    }*/
}
