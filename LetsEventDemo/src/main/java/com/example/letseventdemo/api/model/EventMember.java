package com.example.letseventdemo.api.model;

import com.example.letseventdemo.api.model.id_classes.EventMemberId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "event_member")
@IdClass(EventMemberId.class)
public class EventMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User member;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id")
    private Event event;

    @Column(name = "role")
    private String role;

    public EventMember() {}

    public EventMember(Event event, User user, String role) {
        this.event = event;
        this.member = user;
        this.role = role;
    }

    public User getMember() {
        return member;
    }

    public Event getEvent() {
        return event;
    }

    public String getRole() {
        return role;
    }
}
