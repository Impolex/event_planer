package com.example.letseventdemo.api.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name= "events")
public class Event {

    //Attributes
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "event")
    private List<EventMember> participants = new ArrayList<>();

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    //private String place;

    //Constructor
    public Event(String title, String description/*, String place*/, String date){
        this.title = title;
        this.description = description;
        //this.place = place;
        this.date = date;
    }

    public Event() {

    }

    public List<EventMember> getParticipants() {
        return participants;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
            return title;
        }

    public String getDescription() {
            return description;
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

    /*public void setPlace(String place) {
        this.place = place;
    }*/

    /**
     * Adds the specified user to the participants list, opens a participator view UI and adds the UI to the UIs list.
     * @param user The user instance to be added
     */
    public EventMember addParticipator(User user, String role){
        EventMember member = new EventMember(this, user, role);
        participants.add(member);
        return member;
    }
    /**
     * Closes the UI of the specified user, removes the UI from the UIs list and removes the user from the participants list.
     * @param user The user instance to be removed
     */
    public Optional<EventMember> removeParticipator(User user) {
        Optional<EventMember> member = participants.stream().filter(u -> u.getMember().getUserId() == user.getUserId()).findFirst();
        return member;
    }

    public boolean isMember(String user) {
        return getParticipants()
        .stream()
        .anyMatch(member -> member
                .getMember()
                .getUserName()
                .equals(user)
        );
    }
    public boolean isHost(String user) {
        return getParticipants()
                .stream()
                .anyMatch(member -> member
                        .getMember()
                        .getUserName()
                        .equals(user)
                        && member.getRole().equals("host")
                );
    }
}
