package com.example.letseventdemo.service;

import com.example.letseventdemo.api.model.Event;
import com.example.letseventdemo.api.model.EventMember;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.repositories.EventMemberRepository;
import com.example.letseventdemo.api.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private EventRepository eventRepository;

    private EventMemberRepository eventMemberRepository;

    private int eventCount = 0;

    public EventService(EventRepository eventRepository, EventMemberRepository eventMemberRepository) {
        this.eventRepository = eventRepository;
        this.eventMemberRepository = eventMemberRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
        //return events.values().stream().toList();
    }

    public Optional<Event> getEvent(Integer id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        //event.getParticipants().forEach(eventMemberRepository::save);
        return eventRepository.save(event);
    }

    public void addMember(Event event, User user, String role) {
        EventMember member = event.addParticipator(user, role);
        eventMemberRepository.save(member);
        eventRepository.save(event);
    }
    public void addMember(Event event, User user) {
        EventMember member = event.addParticipator(user, "member");
        eventMemberRepository.save(member);
        eventRepository.save(event);
    }

    public boolean deleteEvent(Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.delete(event.get());
            return true;
        }
        return false;
    }

    public void removeMember(Event event, User user) {
        Optional<EventMember> member = event.removeParticipator(user);
        if (member.isPresent()) {
            eventMemberRepository.delete(member.get());
        }
    }
}
