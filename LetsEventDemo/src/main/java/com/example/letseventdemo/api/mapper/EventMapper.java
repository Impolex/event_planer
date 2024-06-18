package com.example.letseventdemo.api.mapper;

import com.example.letseventdemo.api.model.Event;
import com.example.letseventdemo.api.model.EventMember;
import com.example.letseventdemo.api.model.dto.EventDTO;

import java.util.List;

public class EventMapper {

    public static EventDTO eventDTO(Event event) {
        Integer eventId = event.getId();
        String title = event.getTitle();
        String description = event.getDescription();
        String date = event.getDate();
        List<EventMember> participants = event.getParticipants();
        EventDTO dto = new EventDTO(eventId, title, description, date, participants);
        return dto;
    }

}
