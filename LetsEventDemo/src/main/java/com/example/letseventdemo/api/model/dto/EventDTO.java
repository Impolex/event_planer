package com.example.letseventdemo.api.model.dto;

import com.example.letseventdemo.api.mapper.EventMemberMapper;
import com.example.letseventdemo.api.model.Chat;
import com.example.letseventdemo.api.model.EventMember;
import com.example.letseventdemo.api.model.User;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {

    Integer eventId;
    String title;
    String description;
    String date;
    List<EventMemberDTO> participants;
    //String place;

    public EventDTO (Integer eventId, String title, String description, String date/*, String place*/, List<EventMember> participants) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.participants = participants.stream().map(EventMemberMapper::toEventMapperDTO).toList();
        //this.place = place;
    }
    public void setEventId(int id) {
        eventId = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    /*public String getPlace() {
        return place;
    }*/

    public Integer getEventId() {
        return eventId;
    }

    public List<EventMemberDTO> getParticipants() {
        return participants;
    }
}
