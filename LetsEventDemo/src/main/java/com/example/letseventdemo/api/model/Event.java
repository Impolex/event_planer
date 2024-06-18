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

    /*@ManyToOne
    @JoinColumn(name = "host")
    private User host;*/

    /*@ManyToMany(mappedBy = "events")
    private List<User> organisators = new ArrayList<>();*/

    @OneToMany(mappedBy = "event")
    private List<EventMember> participants = new ArrayList<>();

    /*@OneToOne(mappedBy = "events")
    private Chat chat;*/

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    //private String place;

    //Constructor
    public Event(User host, String title, String description/*, String place*/, String date){
        //this.chat = new Chat();
        this.title = title;
        this.description = description;
        //this.place = place;
        this.date = date;
        //chat = new Chat();
        this.participants.add(new EventMember(this, host, "host"));
        //this.organisators.add(host);
        //this.host = host;
    }

    public Event() {

    }

    //Methods
    /*public User getHost() {
        return host;
    }*/


    /*public List<User> getOrganisators() {
        return organisators;
    }*/

    public List<EventMember> getParticipants() {
        return participants;
    }

    /*public Chat getChat() {
        return chat;
    }*/

    public Integer getId() {
        return id;
    }

    public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        /*public String getPlace() {
            return place;
        }*/

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
        public EventMember addParticipator(User user){
            EventMember member = new EventMember(this, user, "member");
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
        //Host methods
        /**
         * Gives the host status to another user, removing this status from the current host.
         * Checks if the user calling this method is the host, as this action can only be completed by the host.
         * @param currentUser The user instance calling this method
         * @param newHost The user instance to be given host status
         */
        /*public void newHost(User currentUser, User newHost) {
            if(currentUser!=getHost()){
                System.out.println("The User "+currentUser+" cannot complete this action");
            }
            else if(getHost()==newHost){
                System.out.println("User "+newHost+" is already hosting this Event");
            }
            else{
                host = newHost;
            }
        }*/

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
